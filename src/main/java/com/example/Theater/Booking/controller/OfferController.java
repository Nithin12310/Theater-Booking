package com.example.Theater.Booking.controller;

import com.example.Theater.Booking.dto.LinkTypeOfferDTO;
import com.example.Theater.Booking.dto.OfferDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.RewardStatusDTO;
import com.example.Theater.Booking.service.OfferService;
import com.example.Theater.Booking.service.RewardService;
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
    public ResponseEntity<ResponseDTO> addoffer(@RequestBody OfferDTO rewardOfferDTO) {

        return rewardOfferService.addoffer(rewardOfferDTO);

    }

    @PostMapping("/addlinkoffer")
    public ResponseEntity<ResponseDTO> addlinkoffer(@RequestBody LinkTypeOfferDTO linkOfferDTO) {

        return rewardOfferService.addlinkoffer(linkOfferDTO);
    }

    @GetMapping("/rewardstatus")
    public ResponseEntity<ResponseDTO> rewardStatus(@RequestBody RewardStatusDTO rewardStatusDTO) {

        return rewardService.rewardStatus(rewardStatusDTO);
    }


}
