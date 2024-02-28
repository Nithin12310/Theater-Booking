package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface UserService {

    public ResponseEntity<ResponseDTO> adduser(@RequestBody UserDTO userDTO);
}
