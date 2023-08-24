package com.example.demo.service;

import com.example.demo.model.Flower;
import com.example.demo.model.FlowerOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@AllArgsConstructor
public class FlowerService {
    private final List<Flower> flowerList = new ArrayList<>();
    private final FlowerOrderService flowerOrderService;
    public void saveFlower(Flower flower){
        flower.setId((long) flowerList.size());
        flowerList.add(flower);
    }

    public void updateFlower(Flower flower){
        Flower selectedFlower = null;
        for (Flower flowerIterator : flowerList){
            if(flowerIterator.getId().equals(flower.getId())){
                selectedFlower = flowerIterator;
                break;
            }
        }

        if(selectedFlower == null){
            return;
        }

        if(flower.getStock() != null){
            selectedFlower.setStock(flower.getStock());
        }

        if(flower.getPrice() != null){
            selectedFlower.setPrice(flower.getPrice());
        }
    }

    public void buyFlower(Long flowerToBuyId, Long quantity){
        Flower selectedFlower = null;
        for (Flower flowerIterator : flowerList){
            if(flowerIterator.getId().equals(flowerToBuyId)){
                selectedFlower = flowerIterator;
                break;
            }
        }
        if(selectedFlower == null || selectedFlower.getStock() < quantity){
            return;
        }

        FlowerOrder flowerOrder = new FlowerOrder((long) flowerOrderService.getFlowerOrderList().size(), flowerToBuyId, quantity, quantity * selectedFlower.getPrice());
        flowerOrderService.saveFlowerOrder(flowerOrder);
    }
}
