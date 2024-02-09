package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.MovieDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    public ResponseEntity<ResponseDTO> addmovie(MovieDTO movieDTO);
    public ResponseEntity<ResponseDTO> movielist();
}
