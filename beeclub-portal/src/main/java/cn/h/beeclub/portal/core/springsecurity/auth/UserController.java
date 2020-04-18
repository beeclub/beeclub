package cn.h.beeclub.portal.core.springsecurity.auth;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.mail.MailEntity;
import cn.h.beeclub.common.mail.MailHandler;
import cn.h.beeclub.member.biz.service.MemberService;
import cn.h.beeclub.member.dto.MemberDto;
import cn.h.beeclub.portal.common.constant.ApiConstant;
import cn.h.beeclub.portal.common.domain.MemberDetailDomain;
import cn.h.beeclub.portal.core.base.AbstractApiController;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUser;
import cn.hutool.core.lang.Validator;

@Controller
@RequestMapping(ApiConstant.API_V1_PREFIX + "/user")
public class UserController{
	
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(value="/getUserInfo", method=RequestMethod.GET)
	@ResponseBody
	public SimpleResult<MemberDetailDomain> getUserInfo(HttpServletRequest request){
		//获取token
		BeeUser user = (BeeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user == null) {
			return SimpleResult.noAuth("登录失效");
		}
		MemberDto member = memberService.getMemberByAccount(user.getUsername());
		MemberDetailDomain res = mapper.map(member, MemberDetailDomain.class);
		return SimpleResult.ok(res);
	}
	
	
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}
}
