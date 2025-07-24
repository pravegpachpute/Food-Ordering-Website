//package com.floobyte.franchise.response;
//
//import com.floobyte.franchise.model.Inventory;
//import com.floobyte.franchise.service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class LowStockNotifier {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @Scheduled(cron = "0 0 9 * * ?") // Every day at 9 AM
//    public void notifyLowStock() {
//        List<Inventory> lowStockProducts = inventoryService.getLowStockProducts(10);
//        if (!lowStockProducts.isEmpty()) {
//            // Send notifications (e.g., WhatsApp, email)
//            System.out.println("Low stock alert sent for products: " + lowStockProducts);
//        }
//    }
//}
