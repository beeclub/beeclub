package cn.h.beeclub.member.biz.service;

import cn.h.beeclub.member.dto.MemberDto;

import java.util.List;
import java.util.Map;

public interface MemberService {

    List<Map> test();

    void signUp(MemberDto memberDto);
    
    MemberDto getMemberByEmail(String email);
    
    MemberDto getMemberByAccount(String account);
}
