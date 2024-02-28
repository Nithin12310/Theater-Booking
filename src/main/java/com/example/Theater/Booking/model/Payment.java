package com.example.Theater.Booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Booking booking;
    private String paymentType;
    private long TotalAmount;
    private String status;


}
