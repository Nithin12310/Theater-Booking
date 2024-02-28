package com.example.Theater.Booking.service.serviceImplementation;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.UserDTO;
import com.example.Theater.Booking.model.User;
import com.example.Theater.Booking.repository.UserRepository;
import com.example.Theater.Booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDTO> adduser(UserDTO userDTO) {
        User user = User.builder().emailId(userDTO.getEmailId()).mobileNo(userDTO.getMobileNo()).build();
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "UserDetails", savedUser));
    }
}
