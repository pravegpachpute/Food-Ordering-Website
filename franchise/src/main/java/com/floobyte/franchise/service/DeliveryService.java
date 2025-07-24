//package com.floobyte.franchise.service;
//
//import com.floobyte.franchise.model.Delivery;
//import com.floobyte.franchise.repository.DeliveryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class DeliveryService {
//
//    @Autowired
//    private DeliveryRepository repository;
//
//    public Delivery assignDelivery(Delivery delivery) {
//        return repository.save(delivery);
//    }
//
//    public Delivery updateStatus(Long id, String status, String geolocation) {
//        Delivery delivery = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + id));
//        delivery.setStatus(status);
//        delivery.setGeolocation(geolocation);
//        return repository.save(delivery);
//    }
//
//    public Optional<Delivery> trackDelivery(Long id) {
//        return repository.findById(id);
//    }
//}
