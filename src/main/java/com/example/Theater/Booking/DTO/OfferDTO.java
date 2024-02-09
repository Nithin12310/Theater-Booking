package com.example.Theater.Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDTO {

    private String rewardType;
    private String rewards;
    private int validity;

}
