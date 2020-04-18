package cn.h.beeclub.admin.system.controller;

import cn.h.beeclub.admin.common.constant.AdminConstant;
import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.admin.system.domain.SysResource;
import cn.h.beeclub.admin.system.service.SysAdminService;
import cn.h.beeclub.admin.system.service.SysResourceService;
import cn.h.beeclub.admin.system.service.SysRoleService;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.core.auth.Permission;
import cn.h.beeclub.core.auth.ServletContext;
import cn.h.beeclub.core.auth.shiro.JwtToken;
import cn.h.beeclub.core.util.EncodeUtils;
import cn.h.beeclub.core.util.JWTUtils;
import cn.h.beeclub.core.util.JwtUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(tags = "后台权限操作")
@Controller
public class AuthController {

	@Value("${admin.home}")
	private  String adminHome;
	
	@Autowired
	private SysAdminService sysAdminService;

	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysResourceService sysResourceService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@ApiOperation("没有认证过")
	@RequestMapping(value="/noAuth", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public SimpleResult<Integer> noAuth() {
		return SimpleResult.noAuth("noAuth");
	}

	@ApiOperation("认证失败")
	@RequestMapping(value="/authFail", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public SimpleResult<Integer> authFail() {
		return SimpleResult.authFail("authFail");
	}

	@ApiOperation("登录接口")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult<Map<String,Object>> doLogin(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpServletRequest request) {
		SimpleResult<Map<String,Object>> res = new SimpleResult<Map<String,Object>>();
		SysAdmin sysAdmin = sysAdminService.getAdminByMoible(email);
		if (sysAdmin == null) {
			res.setCode(-1);
			res.setMsg("无效用户。");
			return res;
		}
		sysAdminService.updateLoginTime(sysAdmin.getId());
		
		if (!EncodeUtils.encodePwd(password).equals(sysAdmin.getPassword())) {
			res.setCode(-1);
			res.setMsg("密码错误。");
			return res;
		}
		sysAdmin.setPassword(null);
		List<String> permissions = sysResourceService.getPermissionsByUserId(sysAdmin.getId());
		sysAdmin.setPermissions(new HashSet<>(permissions));
		// 获取所有权限
		String remoteHost = request.getRemoteHost();
        String remoteAddr = request.getRemoteAddr();
        log.info("remoteHost:{} ", remoteHost);
        log.info("remoteAddr:{} ", remoteAddr);
		String tokenStr = JWTUtils.generateToken(email, remoteAddr);
        JwtToken token = new JwtToken(tokenStr);
        
        
//        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(30 * 60);
//        token.setUsername(email);
//        UsernamePasswordToken passwordToken = new 
//        SecurityUtils.getSubject().login(token);
//        List<String> roles = sysRoleService.getRolesByUserId(sysAdmin.getId());
//        sysAdmin.setRoles(new HashSet<String>(roles));
//        ServletContext.setSessionAttr("SESSION_USER", sysAdmin);

		// 从SecurityUtils里边创建一个 subject
//		Subject subject = SecurityUtils.getSubject();
        
//		redisTemplate.opsForValue().set(tokenStr, JSONUtil.toJsonStr(sysAdmin), 7 * 24 * 60 , TimeUnit.MINUTES);
        
        sysAdmin.setLoginIp(remoteAddr);
		redisTemplate.opsForValue().set(AdminConstant.USER_KEY + email, JSONUtil.toJsonStr(sysAdmin), 7 * 24 * 60 , TimeUnit.MINUTES);
		// 在认证提交前准备 token（令牌）
//		String token = JwtUtil.sign(sysAdmin.getEmail(), password);
//		JwtToken jwtToken = new JwtToken(token);
        // 执行认证登陆
//        subject.login(token);
        //根据权限，指定返回数据
        Map<String,Object> resMap = new HashMap<String, Object>();
        List<SysResource> menus = sysResourceService.menuList(sysAdmin.getId());
        resMap.put("token", tokenStr);
        resMap.put("userInfo", sysAdmin);
        resMap.put("menus", menus);
        res.setData(resMap);
		return res;
	}


	@ApiOperation("获取用户信息")
	@ResponseBody
	@RequestMapping(value="/getUserInfo",method = RequestMethod.GET)
	public SimpleResult<Object> getUserInfo(HttpServletRequest request){
		String token = (String) SecurityUtils.getSubject().getPrincipal();

		String username = JWTUtils.getUsername(token);
		if(StringUtils.isBlank(username)){
			return SimpleResult.noAuth("重新登陆");
		}
		SysAdmin admin = sysAdminService.getAdminByMoible(username);
		admin.setPassword(null);
		List<String> permissions = sysResourceService.getPermissionsByUserId(admin.getId());
		admin.setPermissions(new HashSet<>(permissions));
		List<SysResource> menus = sysResourceService.menuList(admin.getId());
		String remoteAddr = request.getRemoteAddr();
		admin.setLoginIp(remoteAddr);
		redisTemplate.opsForValue().set(AdminConstant.USER_KEY + username, JSONUtil.toJsonStr(admin), 7 * 24 * 60 , TimeUnit.MINUTES);
		Map<String,Object> res = new HashMap<>();
		res.put("userInfo", admin);
		res.put("permissions", permissions);
		res.put("menus", menus);
		return SimpleResult.ok(res);
	}

	@ApiOperation("注销")
	@ResponseBody
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public SimpleResult<Boolean> logout(HttpServletRequest request){
		String token = (String) SecurityUtils.getSubject().getPrincipal();

		String username = JWTUtils.getUsername(token);
		if(StringUtils.isBlank(username)){
			return SimpleResult.ok();
		}
		redisTemplate.delete(AdminConstant.USER_KEY + username);
		return SimpleResult.ok();
	}

	public static void main(String[] args) {
		System.out.println(EncodeUtils.encodePwd("123"));
	}

	@RequestMapping("/grant-authorization")
	public ModelAndView grantAuthorization(){
		ModelAndView mv = new ModelAndView("frontRoot");
		mv.addObject("home", adminHome);
		return mv;
	}
}
