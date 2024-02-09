package com.example.Theater.Booking.Service.ServiceImplementation;

import com.example.Theater.Booking.DTO.LinkTypeOfferDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.OfferDTO;
import com.example.Theater.Booking.DTO.RewardStatusDTO;
import com.example.Theater.Booking.Model.LinkTypeOffer;
import com.example.Theater.Booking.Model.Offers;
import com.example.Theater.Booking.Repository.LinkTypeOfferRepository;
import com.example.Theater.Booking.Repository.OffersRepository;
import com.example.Theater.Booking.Service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImplementation implements OfferService {

    @Autowired
    OffersRepository rewardOffersRepository;

    @Autowired
    LinkTypeOfferRepository linkTypeOfferRepository;
    @Override
    public ResponseEntity<ResponseDTO> addoffer(OfferDTO rewardOfferDTO) {
        System.out.println(rewardOfferDTO);
        if(rewardOfferDTO.getRewardType().equals("code")){
           Offers rewardOffers= Offers.builder().rewardType(rewardOfferDTO.getRewardType()).rewards(rewardOfferDTO.getRewards() +" " + UUID.randomUUID()).validity(rewardOfferDTO.getValidity()).build();
            System.out.println(rewardOffers+"kaskkakss");
            Offers savedRewardOffers= rewardOffersRepository.save(rewardOffers);
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"added RewardOffers",savedRewardOffers));

        }
        else {
            Offers rewardOffers= Offers.builder().rewardType(rewardOfferDTO.getRewardType()).rewards(rewardOfferDTO.getRewards()).validity(rewardOfferDTO.getValidity()).build();
            System.out.println(rewardOffers);
            Offers savedRewardOffers= rewardOffersRepository.save(rewardOffers);
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"added RewardOffers",savedRewardOffers));
        }




    }

    @Override
    public ResponseEntity<ResponseDTO> addlinkoffer(LinkTypeOfferDTO linkOfferDTO) {

        LinkTypeOffer linkdOffers= LinkTypeOffer.builder().link(linkOfferDTO.getLink()).publish(linkOfferDTO.isPublish()).build();
        System.out.println(linkdOffers);
        LinkTypeOffer savedRewardOffers= linkTypeOfferRepository.save(linkdOffers);
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"added RewardOffers",savedRewardOffers));


    }


}
