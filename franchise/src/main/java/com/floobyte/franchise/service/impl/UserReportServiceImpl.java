package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.dto.StatsDto;
import com.floobyte.franchise.model.Order;
import com.floobyte.franchise.model.Resturant;
import com.floobyte.franchise.model.UserReport;
import com.floobyte.franchise.repository.OrderRepository;
import com.floobyte.franchise.repository.ResturantRepository;
import com.floobyte.franchise.repository.UserReportRepository;
import com.floobyte.franchise.service.UserReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserReportServiceImpl implements UserReportService {

    private final UserReportRepository userReportRepository;

    // working
    public UserReport getStats(Resturant resturant){
        UserReport sr = userReportRepository.findByResturantId(resturant.getId());
        Double totalIncome = orderRepository.sumAllAmounts();
        Integer totalOrders = orderRepository.sumAllOrders();

        if(sr == null){
        UserReport newReport = new UserReport();
            newReport.setResturant(resturant);
            newReport.setTotalEarnings(totalIncome);
            newReport.setTotalOrders(totalOrders);
        return userReportRepository.save(newReport);
        }else {
            sr.setTotalEarnings(totalIncome);
            sr.setTotalOrders(totalOrders);
            return userReportRepository.save(sr);  // Update existing record
        }
    }

//    @Override
//    public UserReport getUserReport(Resturant resturant) {
//        UserReport sr = userReportRepository.findByResturantId(resturant.getId());
//        Double totalIncome = orderRepository.sumAllAmounts();
//        Integer totalOrders = orderRepository.sumAllOrders();
//
//        if(sr == null){
//            UserReport newReport = new UserReport();
//            newReport.setResturant(resturant);
//            newReport.setTotalEarnings(totalIncome);
//            newReport.setTotalOrders(totalOrders);
//
//            return userReportRepository.save(newReport);
//        }
//        return sr;
//    }

    @Override
    public UserReport updateUserReport(UserReport userReport) {
        return userReportRepository.save(userReport);
    }

    // ********** optional

    @Autowired
    private ResturantRepository restaurantRepository;

    @Autowired
    private OrderRepository orderRepository;

//    @Override
//    public UserReport generateSalesReport(Resturant resturant) {
//        UserReport sr = userReportRepository.findByResturantId(resturant.getId());
//        List<Order> orders = orderRepository.findByResturantId(resturant.getId());
////        Long totalIncome = orderRepository.sumAllAmounts();
//
//        long totalSales = 0;
//        long totalRefunds = 0;
//        Integer totalOrders = 0;
//        Integer canceledOrders = 0;
//
//        for (Order order : orders) {
//            if (order.getOrderStatus() == "CANCELED") {
//                canceledOrders++;
//                totalRefunds += order.getTotlePrice();
//            } else {
//                totalSales += order.getTotlePrice();
//            }
//            totalOrders++;
//        }
//
//        long netEarnings = totalSales - totalRefunds;
//
//        return new UserReport(
//                resturant,
//                totalSales,
//                totalRefunds,
//                netEarnings,
//                totalOrders,
//                canceledOrders
//        );
//    }
}
