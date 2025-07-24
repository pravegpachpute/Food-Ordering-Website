//package com.floobyte.franchise.service;
//
//import com.floobyte.franchise.model.Inventory;
//import com.floobyte.franchise.repository.InventoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Service
//public class InventoryService {
//
//    @Autowired
//    private InventoryRepository repository;
//
//    public Inventory addProduct(Inventory inventory) {
//        return repository.save(inventory);
//    }
//
//    public Inventory updateStock(Long id, int stockLevel, LocalDate expiryDate) {
//        Inventory inventory = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
//        inventory.setStockLevel(stockLevel);
//        inventory.setExpiryDate(expiryDate);
//        return repository.save(inventory);
//    }
//
//    public List<Inventory> getLowStockProducts(int threshold) {
//        return repository.findByStockLevelLessThan(threshold);
//    }
//}
