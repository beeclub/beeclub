package cn.h.beeclub.portal.api.auth;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.portal.common.constant.ApiConstant;
import cn.h.beeclub.portal.core.base.BaseController;
import cn.h.beeclub.portal.vo.request.SubmitOrderParam;
import cn.h.beeclub.sem.biz.domain.OrderDo;
import cn.h.beeclub.sem.biz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.API_V1_PREFIX + "/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public SimpleResult<Boolean> submitOrder(@RequestBody SubmitOrderParam orderParam) {
        //创建订单

        return SimpleResult.ok();
    }


}
