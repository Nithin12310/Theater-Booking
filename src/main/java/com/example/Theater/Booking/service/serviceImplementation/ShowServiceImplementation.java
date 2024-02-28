package com.example.Theater.Booking.service.serviceImplementation;

import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.ShowDTO;
import com.example.Theater.Booking.model.Shows;
import com.example.Theater.Booking.repository.MovieRepository;
import com.example.Theater.Booking.repository.ShowRepository;
import com.example.Theater.Booking.repository.TheaterRepository;
import com.example.Theater.Booking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImplementation implements ShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public ResponseEntity<ResponseDTO> addshows(ShowDTO showDTO) {
        Shows shows = Shows.builder().showType(showDTO.getShowType())
                .theaterId(theaterRepository.findById(showDTO.getTheaterId()).orElseThrow())
                .screensId(showDTO.getScreensId())
                .movieId(movieRepository.findById(showDTO.getMovieId()).orElseThrow())
                .showDate(showDTO.getShowDate()).build();
        Shows savedShowDetails = showRepository.save(shows);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Show_Details", savedShowDetails));
    }

    public ResponseEntity<ResponseDTO> viewshows() {

        List<Shows> viewshows = showRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Shows_List", viewshows));
    }
}
