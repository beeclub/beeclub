package cn.h.beeclub.member.biz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.h.beeclub.member.biz.domain.MemberDo;

public interface MemberMapper {

    List<Map> test();

	void createMember(MemberDo memberDo);

	@Select("select * from t_member where email = #{email}")
	MemberDo getMemberByEmail(String email);
	
	@Select("select * from t_member where account = #{account}")
	MemberDo getMemberByAccount(String account);
}
