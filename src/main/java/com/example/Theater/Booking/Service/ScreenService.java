package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.ScreenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface ScreenService {

    public ResponseEntity<ResponseDTO> addscreen(ScreenDTO screenDTO);

    }
