package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.TheaterDTO;
import com.example.Theater.Booking.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaterManagement/theater")
public class TheaterController {
@Autowired
    TheaterService theaterService;
    @PostMapping("/addtheater")
    ResponseEntity<ResponseDTO> addtheater(@RequestBody TheaterDTO theaterDTO){
      return theaterService.addtheater(theaterDTO);

    }

    @GetMapping("/viewtheaters")
   public ResponseEntity<ResponseDTO> viewtheaters(){
        return theaterService.viewtheaters();
    }
}
