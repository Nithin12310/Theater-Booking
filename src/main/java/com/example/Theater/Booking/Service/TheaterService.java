package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.TheaterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface TheaterService {

    public ResponseEntity<ResponseDTO> addtheater(@RequestBody TheaterDTO theaterDTO);
    public ResponseEntity<ResponseDTO> viewtheaters();
    }
