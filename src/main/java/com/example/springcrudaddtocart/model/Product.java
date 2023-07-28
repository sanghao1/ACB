package com.example.springcrudaddtocart.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Product {
    private Long id;

    @NotBlank //K dc empty,null and space
    private String name;

    @NotBlank
    private String description;

    @Digits(integer = 6, fraction = 3)
    @DecimalMin(value = "0.0")
    private Double unitPrice;
}
