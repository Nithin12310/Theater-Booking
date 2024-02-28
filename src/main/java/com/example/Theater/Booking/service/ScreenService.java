package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.ScreenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ScreenService {

    public ResponseEntity<ResponseDTO> addscreen(ScreenDTO screenDTO);

}
