package com.example.Theater.Booking.repository;

import com.example.Theater.Booking.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
