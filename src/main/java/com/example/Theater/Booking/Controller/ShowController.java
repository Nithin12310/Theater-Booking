package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.ShowDTO;
import com.example.Theater.Booking.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaterManagement/show")
public class ShowController {
@Autowired
    ShowService showService;
   @PostMapping("addshows")
    public ResponseEntity<ResponseDTO> addshows(@RequestBody ShowDTO showDTO){

        return showService.addshows(showDTO);
    }

    @GetMapping("/viewshows")
    public ResponseEntity<ResponseDTO> viewshows(){

       return showService.viewshows();
    }

}
