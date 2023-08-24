package com.example.demo.controller;

import com.example.demo.model.FlowerOrder;
import com.example.demo.service.FlowerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/flower-orders")
public class FlowerOrderController {
    private final FlowerOrderService flowerOrderService;

    @GetMapping
    public List<FlowerOrder> getFlowerOrders(){
        return flowerOrderService.getFlowerOrderList();
    }
}
