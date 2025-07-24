//package com.floobyte.franchise.controller;
//
//import com.floobyte.franchise.model.Inventory;
//import com.floobyte.franchise.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/inventory")
//public class InventoryController {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @PostMapping
//    public Inventory addProduct(@RequestBody Inventory inventory) {
//        return inventoryService.addProduct(inventory);
//    }
//
//    @PutMapping("/{id}")
//    public Inventory updateStock(
//            @PathVariable Long id,
//            @RequestParam int stockLevel,
//            @RequestParam LocalDate expiryDate) {
//        return inventoryService.updateStock(id, stockLevel, expiryDate);
//    }
//
//    @GetMapping("/low-stock")
//    public List<Inventory> getLowStockProducts(@RequestParam int threshold) {
//        return inventoryService.getLowStockProducts(threshold);
//    }
//}
