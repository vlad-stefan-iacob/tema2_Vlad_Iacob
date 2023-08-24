package com.example.demo.service;

import com.example.demo.model.FlowerOrder;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class FlowerOrderService {
    private final List<FlowerOrder> flowerOrderList = new ArrayList<>();

    public void saveFlowerOrder(FlowerOrder flowerOrder){
        flowerOrderList.add(flowerOrder);
    }
}
