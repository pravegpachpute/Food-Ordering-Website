package com.floobyte.franchise.controller;

import com.floobyte.franchise.model.User;
//import com.floobyte.franchise.request.ResetPasswordRequest;
//import com.floobyte.franchise.response.UpdatePasswordResponse;
import com.floobyte.franchise.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/profile")
    public ResponseEntity<User> findByUserJwtToken(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        log.info(" call get all  users");
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

//    @SecurityRequirement(name = "bearerAuth")
//    @PutMapping("/updatePassword")
//    public  ResponseEntity<UpdatePasswordResponse> sendResetUrl(@RequestBody ResetPasswordRequest resetPasswordRequest){
//        log.info("call  send reset link");
//        return  ResponseEntity.ok().body(userService.updatePassword(resetPasswordRequest));
//    }
}
