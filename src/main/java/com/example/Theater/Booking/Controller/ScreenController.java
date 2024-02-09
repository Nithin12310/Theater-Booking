package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.ScreenDTO;
import com.example.Theater.Booking.Service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaterManagement/screen")
public class ScreenController {
    @Autowired
    ScreenService screenService;
    @PostMapping("/addscreen")
    public ResponseEntity<ResponseDTO> addscreen(@RequestBody ScreenDTO screenDTO){

        return screenService.addscreen(screenDTO);
    }
}
