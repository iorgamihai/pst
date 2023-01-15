package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Orders;
import com.proiect.ecommerce.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    //GetMapping pentru toate comenzile
    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    //GetMapping dupa ID
    @GetMapping("/{id}")
    public Orders getAllOrdersbyId(@PathVariable("id") Integer id) {
        return ordersService.getOrders(id);
    }


}
