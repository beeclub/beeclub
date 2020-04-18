package cn.h.beeclub.portal.core.springsecurity.auth;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.mail.MailEntity;
import cn.h.beeclub.common.mail.MailHandler;
import cn.h.beeclub.member.biz.service.MemberService;
import cn.h.beeclub.member.dto.MemberDto;
import cn.h.beeclub.portal.common.api.AbstractPublicApi;
import cn.hutool.core.lang.Validator;

public class AuthController extends AbstractPublicApi{
	
	@Autowired
	private MailHandler mailHandler;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final String SIGN_UP_AUTO_CODE_PRE = "sign_up_auto_code_pre_";
	private static final long SIGN_UP_AUTO_CODE_EXPIRE = 10 * 60;
	
	
	@RequestMapping(value="/sendCodeToEmailForSignUp", method=RequestMethod.GET)
	@ResponseBody
	public SimpleResult<Boolean> sendCodeToEmailForSignUp(@RequestParam(value = "email", required = false) String email,
			HttpServletRequest request){
		if(StringUtils.isBlank(email)) {
			return SimpleResult.fail("邮箱不能为空");
		}
		if(!Validator.isEmail(email)) {
			return SimpleResult.fail("无效邮箱");
		}
		MemberDto memberDto = memberService.getMemberByEmail(email);
		if(memberDto != null) {
			return SimpleResult.fail("该邮箱已经存在，请登录或者换邮箱注册");
		}
		String code = "1234";
		MailEntity mail = new MailEntity();
		mail.setRecipient(email);
		mail.setSubject("注册小蜜蜂课堂验证码");
		mail.setContent(String.format("欢迎注册小蜜蜂课堂，您的验证码是：%s，有效时间十分钟", code));
		
		String remoteHost = request.getRemoteHost();
		redisTemplate.opsForValue().setIfAbsent(String.format("SIGN_UP_AUTO_CODE_PRE%s_%s",remoteHost, email), code, SIGN_UP_AUTO_CODE_EXPIRE, TimeUnit.MINUTES);
		mailHandler.sendSimpleMail(mail);
		return SimpleResult.ok();
	}
	
	
//	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult<String> signUp(@RequestParam String username,
			@RequestParam String password){
		MemberDto memberDto = memberService.getMemberByEmail(username);
		if(memberDto == null) {
			return SimpleResult.fail("用户不存在");
		}
		String token= UUID.randomUUID().toString();
		
		
		return SimpleResult.ok(token);
		
	}
	
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult<Boolean> signUp(@RequestParam String email,
			@RequestParam String password,
			@RequestParam String authCode
			){
		if(!Validator.isEmail(email)) {
			return SimpleResult.fail("无效邮箱");
		}
		String code = (String) redisTemplate.opsForValue().get(SIGN_UP_AUTO_CODE_PRE + email);
		if(StringUtils.isBlank(code) || !code.equals(authCode)) {
			return SimpleResult.fail("验证码不存在或已失效");
		}
		
//		MemberDto memberDto = memberService.getMemberByEmail(email);
//		if(memberDto != null) {
//			return SimpleResult.fail("该邮箱已经存在，请登录或者换邮箱注册");
//		}
		String resPw = passwordEncoder.encode(password);
		MemberDto param = new MemberDto();
		param.setEmail(email);
		param.setPassword(resPw);
		memberService.signUp(param);
		return SimpleResult.ok();
	}
}
