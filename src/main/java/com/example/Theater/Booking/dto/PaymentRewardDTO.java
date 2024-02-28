package com.example.Theater.Booking.dto;

import com.example.Theater.Booking.model.Payment;
import com.example.Theater.Booking.model.Rewards;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRewardDTO {

    Payment payment;
    List<Rewards> rewards;

}
