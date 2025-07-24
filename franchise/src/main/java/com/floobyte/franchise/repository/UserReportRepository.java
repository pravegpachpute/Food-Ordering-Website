package com.floobyte.franchise.repository;


import com.floobyte.franchise.model.UserReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReportRepository extends JpaRepository<UserReport, Long> {

    UserReport findByResturantId(Long resturantId);
}
