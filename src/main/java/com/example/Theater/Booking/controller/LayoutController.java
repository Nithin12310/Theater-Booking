package com.example.Theater.Booking.controller;

import com.example.Theater.Booking.dto.GetLayoutDTO;
import com.example.Theater.Booking.dto.LayoutDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/theaterManagement/layout")
public class LayoutController {
    @Autowired
    LayoutService layoutService;

    @PostMapping("/addlayout")
    public ResponseEntity<ResponseDTO> addlayout(@RequestBody LayoutDTO layoutDTO) {
        return layoutService.addlayout(layoutDTO);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getLayout(@RequestBody GetLayoutDTO getLayoutDTO) throws NumberFormatException, ParseException {
        return layoutService.getLayout(getLayoutDTO);
    }

}
