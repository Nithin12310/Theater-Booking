package com.example.Theater.Booking.controller;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.TheaterDTO;
import com.example.Theater.Booking.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theaterManagement/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/addtheater")
    ResponseEntity<ResponseDTO> addtheater(@RequestBody TheaterDTO theaterDTO) {
        return theaterService.addtheater(theaterDTO);

    }

    @GetMapping("/viewtheaters")
    public ResponseEntity<ResponseDTO> viewtheaters() {
        return theaterService.viewtheaters();
    }
}
