package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.dto.RestorantDto;
import com.floobyte.franchise.model.Address;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.repository.AddessRepository;
import com.floobyte.franchise.repository.ResturantRepository;
import com.floobyte.franchise.repository.UserRepository;
import com.floobyte.franchise.request.CreateResturantRequest;
import com.floobyte.franchise.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResturantServiceImpl implements ResturantService {

    @Autowired
    private ResturantRepository resturantRepository;

    @Autowired
    private AddessRepository addessRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Resturant createResturant(CreateResturantRequest req, User user) {
        Address address = addessRepository.save(req.getAddress());

        Resturant resturant = new Resturant();
        resturant.setAddress(address);
        resturant.setContactInformation(req.getContactInformation());
        resturant.setCuisineType(req.getCuisineType());
        resturant.setDescription(req.getDescription());
        resturant.setImages(req.getImages());
        resturant.setName(req.getName());
        resturant.setOpeningHours(req.getOpeningHours());
        resturant.setRegistrationDate(LocalDateTime.now());
        resturant.setOwner(user);

        return resturantRepository.save(resturant);
    }

    @Override
    public Resturant updateResturant(Long resturantId, CreateResturantRequest updateResturant) throws Exception {
       Resturant resturant = findResturantById(resturantId);

       if(resturant.getCuisineType()!=null){
           resturant.setCuisineType(updateResturant.getCuisineType());
       }
        if(resturant.getDescription()!=null){
            resturant.setDescription(updateResturant.getDescription());
        }
        if(resturant.getContactInformation()!=null){
            resturant.setContactInformation(updateResturant.getContactInformation());
        }
        if(resturant.getAddress()!=null){
            resturant.setAddress(updateResturant.getAddress());
        }
        if(resturant.getImages()!=null){
            resturant.setImages(updateResturant.getImages());
        }
        if(resturant.getOpeningHours()!=null){
            resturant.setOpeningHours(updateResturant.getOpeningHours());
        }
        return resturantRepository.save(resturant);
    }

    @Override
    public void  deleteResturant(Long resturantId) throws Exception {
       Resturant resturant = findResturantById(resturantId);
        resturantRepository.delete(resturant);
    }

    @Override
    public List<Resturant> getAllResturant() {
        return resturantRepository.findAll();
    }

    @Override
    public List<Resturant> searchResturant(String keyword) {
        return resturantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Resturant findResturantById(Long id) throws Exception {
        Optional<Resturant> opt = resturantRepository.findById(id);

        if(opt.isEmpty()){
            throw new Exception("Resturant not Found with id" +id);
        }
        return opt.get();
    }

    @Override
    public Resturant getResturantByUserId(Long userid) throws Exception {
        Resturant resturant = resturantRepository.findByOwnerId(userid);
        if(resturant==null){
            throw new Exception("Resturant not found with owner id"+userid);
        }
        return resturant;
    }

    @Override
    public RestorantDto addToFavorites(long resturantId, User user) throws Exception {
        Resturant resturant = findResturantById(resturantId);

        RestorantDto dto = new RestorantDto();
        dto.setDescription(resturant.getDescription());
        dto.setImages(resturant.getImages());
        dto.setTitle(resturant.getName());
        dto.setId(resturantId);

        boolean isFavorited = false;
        List<RestorantDto> favorites = user.getFavourites();
        for(RestorantDto favorite : favorites){
            if(favorite.getId().equals(resturantId)){
                isFavorited=true;
                break;
            }
        }
        if (isFavorited) {
            favorites.removeIf(favorite-> favorite.getId().equals(resturantId));
        } else {
            favorites.add(dto);
        }
        userRepository.save(user);
        return dto;
    }

    @Override
    public Resturant updateResturantStatus(Long id) throws Exception {
        Resturant resturant = findResturantById(id);
        resturant.setOpen(!resturant.isOpen());
        return resturantRepository.save(resturant);
    }

    // ****
//    @Override
//    public Resturant getResturantByEmail(String email) throws Exception {
//        Resturant resturant = resturantRepository.findByEmail(email);
//
//        if(resturant==null){
//            throw new Exception("Resturant not found with email -" +email);
//        }
//        return resturant;
//    }
}
