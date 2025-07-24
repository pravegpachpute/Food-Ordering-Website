package com.floobyte.franchise.service;

import com.floobyte.franchise.dto.RestorantDto;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.CreateResturantRequest;

import java.util.List;

public interface ResturantService {

    public Resturant createResturant(CreateResturantRequest req, User user);

    public Resturant updateResturant(Long resturantId, CreateResturantRequest updateResturant)throws Exception;

    public void deleteResturant(Long resturantId) throws Exception;

    //Only Admin.
    public List<Resturant> getAllResturant();

    // User Search by resturant name.
    public List<Resturant> searchResturant(String keyword);

    // Find By iD.
    public Resturant findResturantById(Long id) throws Exception;

    //
    public Resturant getResturantByUserId(Long userid) throws Exception;

    // Add User Favorite resturant.
    public RestorantDto addToFavorites(long resturantId, User user) throws Exception;

    //Status Resturant Open & close.
    public Resturant updateResturantStatus(Long id) throws Exception;

    // ****
//    Resturant getResturantByEmail(String email) throws Exception;


}
















