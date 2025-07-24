package com.floobyte.franchise.service;

import com.floobyte.franchise.model.User;
//import com.floobyte.franchise.request.ResetPasswordRequest;
import com.floobyte.franchise.response.UpdatePasswordResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User findByUserJwtToken(String jwt) throws Exception;

    public User findByUserEmail(String email) throws Exception;

    List<User> getAllUsers();

//    Optional<User> deleteUSer();

//    UpdatePasswordResponse updatePassword (ResetPasswordRequest resetPasswordRequest);
}
