//package com.floobyte.franchise.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//public class Delivery {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "order_id", nullable = false)
//    private Long orderId;
//
//    @Column(name = "status", nullable = false)
//    private String status;
//
//    @Column(name = "geolocation")
//    private String geolocation;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    // Getters and setters
//}
