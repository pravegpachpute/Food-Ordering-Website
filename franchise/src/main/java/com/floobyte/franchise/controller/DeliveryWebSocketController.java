//package com.floobyte.franchise.controller;
//
//@Controller
//public class DeliveryWebSocketController {
//
//    @Autowired
//    private DeliveryService deliveryService;
//
//    // Broadcast delivery status updates
//    @MessageMapping("/update-delivery") // Maps to /app/update-delivery
//    @SendTo("/topic/delivery-status")  // Sends to /topic/delivery-status
//    public Delivery broadcastDeliveryUpdate(Delivery deliveryUpdate) {
//        // Update delivery status in the database
//        deliveryService.updateStatus(
//                deliveryUpdate.getId(),
//                deliveryUpdate.getStatus(),
//                deliveryUpdate.getGeolocation()
//        );
//
//        // Return updated delivery information
//        return deliveryUpdate;
//    }
//}
//
//**Depedency
//        <dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-websocket</artifactId>
//</dependency>



 //Response class**
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        // Enable a simple message broker for broadcasting messages
//        config.enableSimpleBroker("/topic");
//        // Prefix for application-specific messages
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        // Define WebSocket endpoint
//        registry.addEndpoint("/delivery-updates").setAllowedOrigins("*").withSockJS();
//    }
//
//    **Service class
//
//
//    @Service
//    public class DeliveryService {
//
//        @Autowired
//        private DeliveryRepository repository;
//
//        @Autowired
//        private SimpMessagingTemplate messagingTemplate;
//
//        public Delivery updateStatus(Long id, String status, String geolocation) {
//            Delivery delivery = repository.findById(id)
//                    .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + id));
//            delivery.setStatus(status);
//            delivery.setGeolocation(geolocation);
//            repository.save(delivery);
//
//            // Broadcast the updated delivery information
//            messagingTemplate.convertAndSend("/topic/delivery-status", delivery);
//
//            return delivery;
//        }
