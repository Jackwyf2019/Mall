package com.atguigu.gulimall.order.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class  OrderConfirmVo {
    @Getter
    @Setter
    private List<MemberAddressVo> addresses;

    @Getter
    @Setter
    private List<OrderItemVo> items;

    @Getter
    @Setter
    private String orderToken; // 防重令牌

    // 发票记录

    @Getter
    @Setter
    private Map<Long, Boolean> stocks;

    // 优惠券信息
    @Getter
    @Setter
    private Integer integration;

    public Integer getCount() {
        Integer count = 0;
        if (!CollectionUtils.isEmpty(items)) {
            for (OrderItemVo orderItemVO : items)
                count += orderItemVO.getCount();
        }
        return count;
    }

    // private BigDecimal total; // 订单总额
    public BigDecimal getTotal() {
        BigDecimal sum = new BigDecimal("0");
        if (!CollectionUtils.isEmpty(items)) {
            for (OrderItemVo itemVO : items) {
                BigDecimal multiply = itemVO.getPrice().multiply(new BigDecimal(itemVO.getCount().toString()));
                sum = sum.add(multiply);
            }
        }
        return sum;
    }

    private BigDecimal payPrice; // 应付价格
    public BigDecimal getPayPrice() {
        return getTotal();
    }
}
