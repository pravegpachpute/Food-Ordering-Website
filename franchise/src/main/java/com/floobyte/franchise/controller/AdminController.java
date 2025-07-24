//package com.floobyte.franchise.controller;
//
//import com.floobyte.franchise.config.JwtProvider;
//import com.floobyte.franchise.model.User;
//import com.floobyte.franchise.response.MessageResponse;
//import com.floobyte.franchise.service.OrderService;
//import com.floobyte.franchise.service.ResturantReportService;
//import com.floobyte.franchise.service.ResturantService;
//import com.floobyte.franchise.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//public class AdminController {
//
//    @Autowired
//    private ResturantService resturantService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private ResturantReportService resturantReportService;
//
//    @Autowired
//    private JwtProvider jwtProvider;
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<MessageResponse> deleteResturant(
//
//            @RequestHeader("Authorization") String jwt,
//            @PathVariable Long id
//    ) throws Exception {
//        User user = userService.findByUserJwtToken(jwt);
//
//        resturantService.deleteResturant(id);
//        MessageResponse res = new MessageResponse();
//        res.setMessage("Resturant deleted successfully...");
//        return new ResponseEntity<>(res , HttpStatus.OK);
//    }
//}
