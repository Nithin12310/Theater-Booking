package com.example.Theater.Booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayoutDTO {
    private long theaterId;
    private long screenId;
    private int layout[][];

    private SeatClassificationDTO seatDto;

}
