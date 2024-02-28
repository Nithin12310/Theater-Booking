package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.RewardStatusDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RewardService {

    public ResponseEntity<ResponseDTO> rewardStatus(RewardStatusDTO rewardStatusDTO);
}
