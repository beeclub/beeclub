package cn.h.beeclub.member.biz.service.impl;

import cn.h.beeclub.common.exception.BusinessException;
import cn.h.beeclub.member.biz.dao.MemberMapper;
import cn.h.beeclub.member.biz.domain.MemberDo;
import cn.h.beeclub.member.biz.service.MemberService;
import cn.h.beeclub.member.dto.MemberDto;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    
    @Autowired
    private Mapper mapper;


    @Override
    public List<Map> test() {
        return memberMapper.test();
    }

    @Transactional
    @Override
    public void signUp(MemberDto memberDto) {
//    	String passwd = SecureUtil.md5(memberDto.getPassword());
    	MemberDo member = memberMapper.getMemberByEmail(memberDto.getEmail());
    	if(member != null) {
    		throw new BusinessException("邮箱已被使用");
    	}
    	MemberDo memberDo = mapper.map(memberDto, MemberDo.class);
    	memberDo.setNickname(memberDto.getEmail());
    	memberDo.setType(1);
    	memberMapper.createMember(memberDo);
    }

	@Override
	public MemberDto getMemberByEmail(String email) {
		MemberDo member = memberMapper.getMemberByEmail(email);
		if(member == null) {
			return null;
		}
		MemberDto res = mapper.map(member, MemberDto.class);
		return res;
	}

	@Override
	public MemberDto getMemberByAccount(String account) {
		MemberDo member = memberMapper.getMemberByAccount(account);
		if(member == null) {
			return null;
		}
		MemberDto res = mapper.map(member, MemberDto.class);
		return res;
	}
}
