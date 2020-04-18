package cn.h.beeclub.portal.core.springsecurity.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.h.beeclub.member.biz.service.MemberService;
import cn.h.beeclub.member.dto.MemberDto;
import cn.h.beeclub.portal.common.util.TokenUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BeeUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("===> BeeUserDetailsService start");
		MemberDto member = memberService.getMemberByAccount(username);
		if(member == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		String token = TokenUtils.generateToken(username, null);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		BeeUser beeUser = new BeeUser(member.getId(), username, member.getPassword(), token, authorities);
		log.info("===> BeeUserDetailsService end");
		return beeUser;
	}

}
