package cn.h.beeclub.portal.api.dto.response;

import cn.h.beeclub.common.base.entity.Pair;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItem {

    private Pair.IdName<String,String> subject;
    private BigDecimal price;
    private BigDecimal actualPrice;
    private BigDecimal disacountRatio = new BigDecimal(100);
    private String thumb;

}
