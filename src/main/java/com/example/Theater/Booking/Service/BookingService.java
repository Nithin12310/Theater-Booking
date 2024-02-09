package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.BookingDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    public ResponseEntity<ResponseDTO> book(BookingDTO bookingDTO);
}
