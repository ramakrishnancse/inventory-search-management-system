package com.inventory.helper;

import com.inventory.model.InventorySearchDTO;
import com.inventory.entity.InventoryEntity;

public class InventoryHelper {

    public static InventorySearchDTO toDto(InventoryEntity inventoryEntity){
    InventorySearchDTO inventorySearchDTO = new InventorySearchDTO();

        inventorySearchDTO .setName(inventoryEntity.getName());
        inventorySearchDTO    .setCategory(inventoryEntity.getCategory());
        inventorySearchDTO     .setSubcategory(inventoryEntity.getSubcategory());
        inventorySearchDTO      .setLocation(inventoryEntity.getLocation());
        inventorySearchDTO      .setModel(inventoryEntity.getModel());
        inventorySearchDTO      .setId(inventoryEntity.getId());
        inventorySearchDTO      .setManufacturedAfter(inventoryEntity.getManufacturingDate());
        inventorySearchDTO      .setExpiresBefore(inventoryEntity.getExpiryDate());
        inventorySearchDTO      .setSeller(inventoryEntity.getSeller());

return inventorySearchDTO;
    }



}
