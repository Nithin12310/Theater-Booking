package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.UserDTO;
import com.example.Theater.Booking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaterManagement/user")
public class UserController {
   @Autowired
    UserService userService;
    @PostMapping("/adduser")
    public ResponseEntity<ResponseDTO> adduser(@RequestBody UserDTO userDTO){
        return userService.adduser(userDTO);
    }
}
