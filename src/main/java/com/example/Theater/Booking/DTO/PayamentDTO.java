package com.example.Theater.Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayamentDTO {

    private long bookingId;
    private String paymentType;
    private long TotalAmount;
    private String status;


}
