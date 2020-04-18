package cn.h.beeclub.admin.member.controller;

import cn.h.beeclub.common.base.BaseController;
import cn.h.beeclub.member.biz.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Api(value = "测试", tags = "测试", produces = "http")
@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController{

	
    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "测试", notes = "测试")
    @RequestMapping(value="/test", method= RequestMethod.GET)
    @ResponseBody
    public List<Map> test(){
    	super.getCurrentUser();
        return memberService.test();
    }

}
