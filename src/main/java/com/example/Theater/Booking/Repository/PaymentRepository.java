package com.example.Theater.Booking.Repository;

import com.example.Theater.Booking.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
