package com.example.Theater.Booking.Service.ServiceImplementation;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.ScreenDTO;
import com.example.Theater.Booking.Model.Screen;
import com.example.Theater.Booking.Repository.ScreenRepository;
import com.example.Theater.Booking.Service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImplementation implements ScreenService {
    @Autowired
    ScreenRepository screenRepository;
    @Override
    public ResponseEntity<ResponseDTO> addscreen(ScreenDTO screenDTO) {

        Screen addscreen= Screen.builder()
                .theaterId(screenDTO.getTheaterId())
                .theaterName(screenDTO.getTheaterName())
                .screenName(screenDTO.getScreenName())
                .Facilities(screenDTO.getFacilities()).build();
        Screen savedScreenDetails= screenRepository.save(addscreen);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"screen_Details",savedScreenDetails));
    }
}
