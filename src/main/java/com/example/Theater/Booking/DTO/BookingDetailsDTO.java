package com.example.Theater.Booking.DTO;


import com.example.Theater.Booking.Model.Booking;
import com.example.Theater.Booking.Model.Seat;
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
