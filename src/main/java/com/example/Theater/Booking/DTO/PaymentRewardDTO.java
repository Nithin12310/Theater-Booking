package com.example.Theater.Booking.DTO;

import com.example.Theater.Booking.Model.Payment;
import com.example.Theater.Booking.Model.Rewards;
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
