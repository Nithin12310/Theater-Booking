package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.BookingDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaterManagement/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/book")
    public ResponseEntity<ResponseDTO> book(@RequestBody BookingDTO bookingDTO){

        return bookingService.book(bookingDTO);
    }
}
