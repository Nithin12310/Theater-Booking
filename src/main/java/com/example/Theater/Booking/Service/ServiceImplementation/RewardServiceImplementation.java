package com.example.Theater.Booking.Service.ServiceImplementation;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.RewardStatusDTO;
import com.example.Theater.Booking.Model.Rewards;
import com.example.Theater.Booking.Repository.RewardRepository;
import com.example.Theater.Booking.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class RewardServiceImplementation implements RewardService {

    @Autowired
    RewardRepository rewardRepository;
    @Override
    public ResponseEntity<ResponseDTO> rewardStatus(RewardStatusDTO rewardStatusDTO) {

        Optional<Rewards> rewards= rewardRepository.findById(rewardStatusDTO.getRewardId());

        if(rewardStatusDTO.getFlag()==0){
            rewards.get().setStatus("Opened");

        }
        else{
            rewards.get().setStatus("Used");
        }
      Rewards updatedReward= rewardRepository.save(rewards.get());
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"Reward Status",updatedReward));
    }
   // @Scheduled(fixedDelay = 1000)
    public void checkingExpiryOfReward(){
        List<Rewards> rewards= rewardRepository.findAll();

        Date date= new Date();
        for(Rewards rewards1:rewards){
            Long diff= date.getTime()-rewards1.getExpiryDate().getTime();
            if(diff<=0){
                System.out.println("hiii");
                rewards1.setStatus("Expired");
                rewardRepository.save(rewards1);
            }
        }
    }
}
