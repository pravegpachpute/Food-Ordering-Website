//package com.floobyte.franchise.controller;
//
//import com.floobyte.franchise.model.Delivery;
//import com.floobyte.franchise.service.DeliveryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/delivery")
//public class DeliveryController {
//
//    @Autowired
//    private DeliveryService deliveryService;
//
//    @PostMapping
//    public Delivery assignDelivery(@RequestBody Delivery delivery) {
//        return deliveryService.assignDelivery(delivery);
//    }
//
//    @PutMapping("/{id}/status")
//    public Delivery updateStatus(
//            @PathVariable Long id,
//            @RequestParam String status,
//            @RequestParam String geolocation) {
//        return deliveryService.updateStatus(id, status, geolocation);
//    }
//
//    @GetMapping("/{id}/track")
//    public Optional<Delivery> trackDelivery(@PathVariable Long id) {
//        return deliveryService.trackDelivery(id);
//    }
//}
//




