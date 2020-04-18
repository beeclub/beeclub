package cn.h.beeclub.core.auth.shiro;

import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

@Slf4j
public class UserUtils {

    public static SysAdmin getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
//        Object o =  subject.getPrincipal();
//        PrincipalCollection p = subject.getPrincipals();
//        log.info("getCurrentUser:{}", JSON.toJSONString(o));
//        log.info("getCurrentUser:{}", JSON.toJSONString(p));
//        log.info("getCurrentUser:{}", subject.getSession().getAttribute("userInfo"));
        SysAdmin admin = (SysAdmin) subject.getSession().getAttribute("userInfo");
        log.info("getCurrentUser:{}", admin);
        return admin;
    }

    public static Long getUserId(){
        SysAdmin admin = getCurrentUser();
        log.info("currentUser:{}", JSONUtil.toJsonStr(admin));
        if(admin == null){
            return null;
        }
        return admin.getId();
    }
}
