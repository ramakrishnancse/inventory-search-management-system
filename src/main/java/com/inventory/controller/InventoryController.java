package com.inventory.controller;

import com.inventory.model.InventorySearchDTO;
import com.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/search")
    public ResponseEntity<List<InventorySearchDTO>> searchInventory( InventorySearchDTO inventorySearchDTO) {
        return ResponseEntity.ok(inventoryService.searchInventory(inventorySearchDTO));
    }
}