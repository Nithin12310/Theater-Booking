package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.LinkTypeOfferDTO;
import com.example.Theater.Booking.dto.OfferDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {

    public ResponseEntity<ResponseDTO> addoffer(OfferDTO rewardOfferDTO);

    public ResponseEntity<ResponseDTO> addlinkoffer(LinkTypeOfferDTO linkOfferDTO);
}
