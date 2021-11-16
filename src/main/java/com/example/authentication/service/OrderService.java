package com.example.authentication.service;

import com.example.authentication.domain.Order;
import com.example.authentication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ORDER_DOES_NOT_EXIST")
        );
    }

    public Order getByMSISDN(Long msisdn) throws Exception{
        return orderRepository.findByMsisdn(msisdn);
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order){
        Order existingOrder = orderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ORDER_NOT_FOUND")
        );
        existingOrder.setChannelName(order.getChannelName());
        existingOrder.setOrderSubTypeId(order.getOrderSubTypeId());
        existingOrder.setOrderSubTypeName(order.getOrderSubTypeName());
        existingOrder.setDisconnectReason(order.getDisconnectReason());
        existingOrder.setStatusContext(order.getStatusContext());
        existingOrder.setProductName(order.getProductName());
        existingOrder.setMsisdn(order.getMsisdn());
        existingOrder.setProductId(order.getProductId());
        existingOrder.setAction(order.getAction());
        existingOrder.setStatusName(order.getStatusName());

        orderRepository.save(existingOrder);
        return existingOrder;
    }

    private Long generateMsisdn(){
        int min = (int) 1800000001L;
        int max = (int) 1899999999L;
        return Long.valueOf(new Random().ints(min,max)
                .findFirst().getAsInt());
    }

    private String generateStatus(){
        int msi = (int)(Math.random() * 10);
        if(msi %2 == 0){
            return "AVAILABLE";
        }
        else {
            return "TAKEN";
        }
    }

    public Order generateOrder(){
        Long msisdn = generateMsisdn() + 880000000000L;
        String statusName = generateStatus();
        Long orderSubTypeId = Long.valueOf(21);
        String orderSubTypeName = "ORDER_SUB_TYPE_NAME";
        String action = "ACTION";
        String productName = "PRODUCT_NAME";
        int productId = 12;
        String statusContext = "STATUS_CONTEXT";
        String disconnectReason = "DISCONNECT_REASON";
        String channelName = "CHANNEL_NAME";

        Order order = new Order();
        order.setMsisdn(msisdn);
        order.setStatusName(statusName);
        order.setOrderSubTypeId(orderSubTypeId);
        order.setOrderSubTypeName(orderSubTypeName);
        order.setAction(action);
        order.setProductId(productId);
        order.setProductName(productName);
        order.setStatusContext(statusContext);
        order.setDisconnectReason(disconnectReason);
        order.setChannelName(channelName);

        return orderRepository.save(order);

    }
}
