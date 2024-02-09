package com.example.Theater.Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTypeOfferDTO {

    private String link;
    private boolean publish;
}
