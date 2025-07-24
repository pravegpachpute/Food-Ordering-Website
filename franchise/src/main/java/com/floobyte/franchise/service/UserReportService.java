package com.floobyte.franchise.service;

import com.floobyte.franchise.dto.StatsDto;
import com.floobyte.franchise.model.Resturant;

import com.floobyte.franchise.model.User;
import com.floobyte.franchise.model.UserReport;

public interface UserReportService {

//    UserReport getUserReport(Resturant resturant);

    UserReport updateUserReport(UserReport userReport);

    public UserReport getStats(Resturant resturant);

    // optional
//    public UserReport generateSalesReport(Resturant resturant);
}
