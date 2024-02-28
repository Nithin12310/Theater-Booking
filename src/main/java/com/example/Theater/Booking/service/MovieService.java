package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.MovieDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    public ResponseEntity<ResponseDTO> addmovie(MovieDTO movieDTO);

    public ResponseEntity<ResponseDTO> movielist();
}
