package com.floobyte.franchise.controller;

import com.floobyte.franchise.config.JwtProvider;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.model.UserReport;
import com.floobyte.franchise.request.CreateResturantRequest;
import com.floobyte.franchise.response.MessageResponse;
import com.floobyte.franchise.service.ResturantService;
import com.floobyte.franchise.service.UserReportService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/resturants")
public class AdminResturantController {

    @Autowired
    private ResturantService resturantService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserReportService userReportService;

    @Autowired
    private JwtProvider jwtProvider;

    //Check
    @PostMapping()
    public ResponseEntity<Resturant> createResturant(
            @RequestBody CreateResturantRequest req,
            @RequestHeader("Authorization") String jwt
            ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        Resturant resturant = resturantService.createResturant(req, user);
        return new ResponseEntity<>(resturant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resturant> updateResturant(
            @RequestBody CreateResturantRequest req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        Resturant resturant = resturantService.updateResturant(id, req);
        return new ResponseEntity<>(resturant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteResturant(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        resturantService.deleteResturant(id);
        MessageResponse res = new MessageResponse();
        res.setMessage("Resturant deleted successfully...");
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

    //Check
    @PutMapping("/{id}/status")
    public ResponseEntity<Resturant> updateResturantStatus(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        Resturant resturant = resturantService.updateResturantStatus(id);

        return new ResponseEntity<>(resturant , HttpStatus.OK);
    }

    //Check
    @GetMapping("/user")
    public ResponseEntity<Resturant> findResturantById(

            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        Resturant resturant = resturantService.getResturantByUserId(user.getId());
        return new ResponseEntity<>(resturant , HttpStatus.OK);
    }

    // ****
    // Sells report
//    @GetMapping("/report")
//    public ResponseEntity<UserReport> getResturantReport(@RequestHeader("Authorization") String jwt)
//            throws Exception {
//        User user = userService.findByUserJwtToken(jwt);
//        Resturant resturant = resturantService.getResturantByUserId(user.getId());
//        UserReport report = userReportService.getUserReport(resturant);
//        return new ResponseEntity<>(report, HttpStatus.OK);
//    }

    // total income & expense check working
    @GetMapping("/stats")
    public ResponseEntity<?> getStats(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        Resturant resturant = resturantService.getResturantByUserId(user.getId());
        UserReport report = userReportService.getStats(resturant);
        return ResponseEntity.ok(report);
    }

//    // optional not working
//    @GetMapping("/sales-report")
//    public ResponseEntity<UserReport> getSalesReport(@RequestHeader("Authorization") String jwt)
//            throws Exception {
//        User user = userService.findByUserJwtToken(jwt);
//        Resturant resturant = resturantService.getResturantByUserId(user.getId());
//        UserReport report = userReportService.generateSalesReport(resturant);
//        return ResponseEntity.ok(report);
//    }
}
