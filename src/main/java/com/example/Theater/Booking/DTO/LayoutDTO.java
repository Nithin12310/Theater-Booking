package com.example.Theater.Booking.DTO;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayoutDTO {
    private long theaterId;
    private long screenId;
    private int layout[][];

    private SeatClassificationDTO seatDto;

}
