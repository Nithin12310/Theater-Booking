package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.ShowDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface ShowService {

    public ResponseEntity<ResponseDTO> addshows(ShowDTO showDTO);
    public ResponseEntity<ResponseDTO> viewshows();
}
