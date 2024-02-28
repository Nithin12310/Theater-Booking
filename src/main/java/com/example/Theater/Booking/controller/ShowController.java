package com.example.Theater.Booking.controller;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.ShowDTO;
import com.example.Theater.Booking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theaterManagement/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("addshows")
    public ResponseEntity<ResponseDTO> addshows(@RequestBody ShowDTO showDTO) {

        return showService.addshows(showDTO);
    }

    @GetMapping("/viewshows")
    public ResponseEntity<ResponseDTO> viewshows() {

        return showService.viewshows();
    }

}
