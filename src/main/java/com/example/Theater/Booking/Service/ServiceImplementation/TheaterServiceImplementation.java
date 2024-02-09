package com.example.Theater.Booking.Service.ServiceImplementation;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.TheaterDTO;
import com.example.Theater.Booking.Model.Theater;
import com.example.Theater.Booking.Repository.TheaterRepository;
import com.example.Theater.Booking.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImplementation implements TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    @Override
    public ResponseEntity<ResponseDTO> addtheater(TheaterDTO theaterDTO) {
        Theater theater= Theater.builder().theaterName(theaterDTO.getTheaterName())
                .theaterAddress(theaterDTO.getTheaterAddress()).build();
        Theater savedTheaterDetails=theaterRepository.save(theater);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"TheaterDetails",savedTheaterDetails));
    }

    @Override
    public ResponseEntity<ResponseDTO> viewtheaters() {
        List<Theater> theaterList= theaterRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"Theater_List)",theaterList));
    }
}
