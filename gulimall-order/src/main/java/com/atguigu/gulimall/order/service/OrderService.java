package com.atguigu.gulimall.order.service;

import com.atguigu.gulimall.order.vo.OrderConfirmVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.order.entity.OrderEntity;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 订单
 *
 * @author wyf
 * @email 3190103178@zju.edu.cn
 * @date 2021-02-17 11:08:16
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    OrderConfirmVO confirmOrder() throws ExecutionException, InterruptedException;

}

