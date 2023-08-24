package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerOrder {
    private Long orderId;
    private Long flowerId;
    private Long quantity;
    private Double price;
}
