package com.example.Theater.Booking.Repository;

import com.example.Theater.Booking.Model.Rewards;
import com.example.Theater.Booking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<Rewards,String> {
    Rewards findByUserId(User userid);





    List<Rewards> findAllByUserId(User userid);
}
