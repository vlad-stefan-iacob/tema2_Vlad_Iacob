package com.example.demo.controller;

import com.example.demo.model.Flower;
import com.example.demo.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    @GetMapping
    public List<Flower> getFlowers(){
        return flowerService.getFlowerList();
    }

    @PostMapping
    public void createFlower(@RequestBody Flower flower){
        flowerService.saveFlower(flower);
    }

    @PutMapping
    public void updateFlower(@RequestBody Flower flower){
        flowerService.updateFlower(flower);
    }

    @PostMapping("buy-flower")
    public void buyCar(@RequestParam("flowerId") Long flowerId, @RequestParam("quantity") Long quantity){
        flowerService.buyFlower(flowerId, quantity);
    }

}
