package com.floobyte.franchise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Resturant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //one franshasi have one owner.
    @OneToOne
    private User owner;

    private String name;
    private String description;
    private String cuisineType;

    //one resturant have one address(one owner one address).
    @OneToOne
    private Address address;

    @Embedded
    private ContactInformation contactInformation;

    private String openingHours;

    //one resturant have multiple orders.
    //whenever remove resturant remove orders as well.
    @JsonIgnore
    @OneToMany(mappedBy = "resturant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    //seperate table for images.
    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    //owner register our franshasi platform.
    private LocalDateTime registrationDate;

    private boolean open;

    //one resturant multiple food.
    //cascade we remove hotel from our database remove food entity also.
    //we fetch data resturant no need to list of food.
    @JsonIgnore
    @OneToMany(mappedBy = "resturant", cascade = CascadeType.ALL)
    private List<Food> foods = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "resturant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    //Getter Setter

}
