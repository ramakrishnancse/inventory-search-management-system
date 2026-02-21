package com.inventory.service;

import com.inventory.helper.InventoryHelper;
import com.inventory.model.InventorySearchDTO;
import com.inventory.entity.InventoryEntity;
import com.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;


    public List<InventorySearchDTO> searchInventory(InventorySearchDTO criteria) {
        Specification<InventoryEntity> spec = Specification.where(Specification.unrestricted());

        if (criteria.getName() != null) {

            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));
        }

        if (criteria.getCategory() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("category"), criteria.getCategory()));
        }

        if (criteria.getMinPrice() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(root.get("price"), criteria.getMinPrice()));
        }

        // Need to add logic for Manufacturing Date, Seller, etc.

//        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize(),
//                Sort.by(Sort.Direction.ASC, criteria.getSortBy()));

        List<InventoryEntity> entityList = repository.findAll(spec);


        return entityList.stream().map(inventoryEntity -> InventoryHelper.toDto(inventoryEntity)).toList();
    }


}