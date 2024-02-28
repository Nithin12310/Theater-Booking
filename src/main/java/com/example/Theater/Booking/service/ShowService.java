package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.ShowDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface ShowService {

    public ResponseEntity<ResponseDTO> addshows(ShowDTO showDTO);

    public ResponseEntity<ResponseDTO> viewshows();
}
