package cn.h.beeclub.portal.api.auth;

import cn.h.beeclub.common.base.entity.Pair;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.course.biz.dto.CourseMasterDto;
import cn.h.beeclub.course.biz.service.CourseMasterService;
import cn.h.beeclub.portal.api.dto.response.CartItem;
import cn.h.beeclub.portal.common.constant.ApiConstant;
import cn.h.beeclub.portal.core.base.BaseController;
import cn.h.beeclub.sem.biz.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_V1_PREFIX + "/cart")
public class CartController extends BaseController {

    @Autowired
    private CourseMasterService courseMasterService;

    @GetMapping("/course")
    public SimpleResult<List<CartItem>> get(@RequestParam("courseIds") String[] courseIds) {
        List<CartItem> res = new ArrayList<>();
        if (courseIds.length == 0) {
            return SimpleResult.ok(Collections.emptyList());
        }
        courseMasterService.findCoursesByIds(Arrays.asList(courseIds)).forEach(courseMasterDto -> {
            CartItem cartItem = new CartItem();
            cartItem.setSubject(new Pair.IdName<>(courseMasterDto.getId(), courseMasterDto.getTitle()));
            cartItem.setThumb(courseMasterDto.getThumb());
            PriceDto price = courseMasterDto.getPrice();
            BigDecimal disacountRatio = price.getDisacountRatio();
            if (price.getFree()) {
                cartItem.setActualPrice(BigDecimal.ZERO);
                cartItem.setPrice(BigDecimal.ZERO);
            } else {

                BigDecimal disacountPrice = price.getDisacountPrice();
                cartItem.setPrice(price.getOriginPrice());
                if(disacountPrice != null || BigDecimal.ZERO.equals(disacountPrice)){
                    cartItem.setActualPrice(price.getDisacountPrice());
                }else{
                    if(disacountRatio != null && !BigDecimal.ZERO.equals(disacountRatio)){
                        cartItem.setActualPrice(disacountRatio.multiply(price.getOriginPrice()));
                    }else{
                        cartItem.setActualPrice(price.getOriginPrice());
                    }
                }
            }
            cartItem.setDisacountRatio( BigDecimal.ZERO.equals(cartItem.getActualPrice()) ? BigDecimal.valueOf(100) :  cartItem.getPrice().divide(cartItem.getActualPrice()));
            res.add(cartItem);
        });
        return SimpleResult.ok(res);
    }

}
