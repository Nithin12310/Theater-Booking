package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.LinkTypeOfferDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.OfferDTO;
import com.example.Theater.Booking.DTO.RewardStatusDTO;
import com.example.Theater.Booking.Service.OfferService;
import com.example.Theater.Booking.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theaterManagement/rewardoffer")
public class OfferController {
@Autowired
OfferService rewardOfferService;
@Autowired
    RewardService rewardService;
    @PostMapping("/addoffer")
    public ResponseEntity<ResponseDTO> addoffer(@RequestBody OfferDTO rewardOfferDTO){

     return rewardOfferService.addoffer(rewardOfferDTO);

    }

    @PostMapping("/addlinkoffer")
    public  ResponseEntity<ResponseDTO> addlinkoffer(@RequestBody LinkTypeOfferDTO linkOfferDTO){

        return rewardOfferService.addlinkoffer(linkOfferDTO);
    }

    @GetMapping("/rewardstatus")
    public ResponseEntity<ResponseDTO> rewardStatus(@RequestBody RewardStatusDTO rewardStatusDTO){

        return rewardService.rewardStatus(rewardStatusDTO);
    }


}
