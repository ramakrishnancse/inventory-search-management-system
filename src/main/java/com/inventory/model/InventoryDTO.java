package com.inventory.model;

import java.time.LocalDate;
import java.util.Map;

public class InventoryDTO {
    private Long id;
    private String name;
    private String category;
    private String subcategory;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private Map<String, Object> specification; // Maps to the 'object' in YAML
    private Double price;
    private Integer stock;
    private String model;
    private String seller;
    private String location;
}
