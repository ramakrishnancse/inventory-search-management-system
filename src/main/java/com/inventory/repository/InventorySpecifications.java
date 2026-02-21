package com.inventory.repository;

import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDate;

public class InventorySpecifications {

    public static Specification<InventoryEntity> hasName(String name) {
        return (root, query, cb) -> name == null ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<InventoryEntity> hasCategory(String category) {
        return (root, query, cb) -> category == null ? null : cb.equal(root.get("category"), category);
    }

    public static Specification<InventoryEntity> isAvailable() {
        return (root, query, cb) -> cb.greaterThan(root.get("stock"), 0);
    }

    public static Specification<InventoryEntity> manufacturedAfter(LocalDate date) {
        return (root, query, cb) -> date == null ? null : cb.greaterThanOrEqualTo(root.get("manufacturingDate"), date);
    }

    // Add more for Seller, Location, Model, etc.
}