package com.floobyte.franchise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReport {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Resturant resturant;

    private Double totalEarnings= 0.0;
    private Integer totalOrders = 0;


}


// UserReport -> UserReportRepository -> UserReportService -> UserReportServiceImpl -> AdminResturantController - get report
// -> ordercontroller - cancel total orders ->