package com.example.Theater.Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatLayoutDTO {

    private String seatType;
    private String seatRange;
    private int seatPrice;
}
