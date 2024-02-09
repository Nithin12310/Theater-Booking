package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.RewardStatusDTO;
import com.example.Theater.Booking.Model.Rewards;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public interface RewardService {

    public ResponseEntity<ResponseDTO> rewardStatus(RewardStatusDTO rewardStatusDTO);
}
