package cn.h.beeclub.portal.vo.request;

import lombok.Data;
import org.apache.poi.hpsf.Decimal;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubmitOrderParam {

    private List<OrderItemPram> items = new ArrayList<>();
    private Decimal amount;
    private Decimal actualAmount;

    public static class OrderItemPram {

        private Long skuId;
        private Integer quantity;
    }
}
