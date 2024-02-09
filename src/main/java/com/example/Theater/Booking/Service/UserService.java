package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public interface UserService {

    public ResponseEntity<ResponseDTO> adduser(@RequestBody UserDTO userDTO);
}
