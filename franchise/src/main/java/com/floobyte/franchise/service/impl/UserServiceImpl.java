package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.config.JwtProvider;
import com.floobyte.franchise.controller.UserController;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.repository.UserRepository;
import com.floobyte.franchise.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;
    

//    @Autowired
//    private JwtService jwtService;

    @Override
    public User findByUserJwtToken(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        User user = findByUserEmail(email);
        return user;
    }

    @Override
    public User findByUserEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if(user==null){
            throw new Exception("User Not Found");
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public UpdatePasswordResponse updatePassword(ResetPasswordRequest resetPasswordRequest) {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        var token = securityContext.getAuthentication().getCredentials().toString();
//        var userEmail = jwtService.extractUserName(token);
//        User user = userRepository.findByEmails(userEmail).orElseThrow(() ->
//                new ApiRequestException(" user not found", HttpStatus.NOT_FOUND));
//        if (passwordEncoder.matches(resetPasswordRequest.getOldPassword(), user.getPassword())) {
//            String encodedPassword = passwordEncoder.encode(resetPasswordRequest.getNewPassword());
//            log.info(encodedPassword);
//            user.setPassword(encodedPassword);
//            userRepository.save(user);
//            log.info(" user  password have been updated successfully");
//            return
//                    UpdatePasswordResponse.builder()
//                            .email(userEmail)
//                            .msg(" user with this email have updated his password successfully")
//                            .build();
//        } else {
//            throw new ApiRequestException(" please  make sure that old password match with that one  you have saved in db", HttpStatus.BAD_REQUEST);
//        }
//    }
}






