package cn.h.beeclub.portal.core.base;

import cn.h.beeclub.common.base.entity.Pair;
import cn.h.beeclub.portal.core.springsecurity.support.BeeUser;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {


    protected BeeUser getCurrentUser(){
        //获取token
        BeeUser user = (BeeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    protected Pair.IdName<Long, String> getCurrentUserIdName(){
        BeeUser currentUser = this.getCurrentUser();
        if(currentUser == null){
            return null;
        }
        return new Pair.IdName<>(currentUser.getUserId(), currentUser.getUsername());
    }

    protected Long getCurrentUserId(){
        BeeUser currentUser = this.getCurrentUser();
        if(currentUser != null){
            currentUser.getUserId();
        }
        return null;
    }
}
