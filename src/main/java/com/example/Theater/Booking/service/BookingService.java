package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.BookingDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    public ResponseEntity<ResponseDTO> book(BookingDTO bookingDTO);

}
