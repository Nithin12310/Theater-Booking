package com.example.Theater.Booking.service.serviceImplementation;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.ScreenDTO;
import com.example.Theater.Booking.model.Screen;
import com.example.Theater.Booking.repository.ScreenRepository;
import com.example.Theater.Booking.service.ScreenService;
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

        Screen addscreen = Screen.builder()
                .theaterId(screenDTO.getTheaterId())
                .theaterName(screenDTO.getTheaterName())
                .screenName(screenDTO.getScreenName())
                .Facilities(screenDTO.getFacilities()).build();
        Screen savedScreenDetails = screenRepository.save(addscreen);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "screen_Details", savedScreenDetails));
    }
}
