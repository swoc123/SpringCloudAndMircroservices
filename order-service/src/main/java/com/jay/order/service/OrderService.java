package com.jay.order.service;

import com.jay.feign.clients.UserClient;
import com.jay.feign.pojo.User;
import com.jay.order.mapper.OrderMapper;
import com.jay.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
//        Long id = order.getUserId();
//        String url = "http://userservice/user/"+ id;
//        User user  = restTemplate.getForObject(url, User.class);   // tell restTemplate which type class do you want it to deserialize from jason to java object
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }
}
