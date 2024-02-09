package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.LinkTypeOfferDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.OfferDTO;
import com.example.Theater.Booking.DTO.RewardStatusDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface OfferService {

    public ResponseEntity<ResponseDTO> addoffer(OfferDTO rewardOfferDTO);

    public  ResponseEntity<ResponseDTO> addlinkoffer( LinkTypeOfferDTO linkOfferDTO);
}
