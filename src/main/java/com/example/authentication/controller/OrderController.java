package com.example.authentication.controller;

import com.example.authentication.domain.Order;
import com.example.authentication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/search/id/{id}")
    public Order findById(@PathVariable(value = "id") Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/search/msisdn/{msisdn}")
    public Order findByMSISDN(@PathVariable(name = "msisdn") Long msisdn) throws Exception{
        return orderService.getByMSISDN(msisdn);
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/order") // generate demo content for order table
    public Order generateOrder(){
        return orderService.generateOrder();
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable(value = "id") Long id, @RequestBody Order order){
        return orderService.updateOrder(id, order);
    }
}
