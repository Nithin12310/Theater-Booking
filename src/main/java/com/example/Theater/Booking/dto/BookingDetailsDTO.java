package com.example.Theater.Booking.dto;


import com.example.Theater.Booking.model.Booking;
import com.example.Theater.Booking.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailsDTO {

    private Booking booking;
    private List<Seat> seats;
}
