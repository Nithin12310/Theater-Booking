package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.GetLayoutDTO;
import com.example.Theater.Booking.DTO.LayoutDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.Service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/theaterManagement/layout")
public class LayoutController {
   @Autowired
    LayoutService layoutService;
    @PostMapping("/addlayout")
    public ResponseEntity<ResponseDTO> addlayout(@RequestBody LayoutDTO layoutDTO){
        return layoutService.addlayout(layoutDTO);


    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getLayout(@RequestBody GetLayoutDTO getLayoutDTO) throws NumberFormatException,ParseException {
        return layoutService.getLayout(getLayoutDTO);
    }

}
