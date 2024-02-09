package com.example.Theater.Booking.Service.ServiceImplementation;

import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.ShowDTO;
import com.example.Theater.Booking.Model.Movie;
import com.example.Theater.Booking.Model.Shows;
import com.example.Theater.Booking.Model.Theater;
import com.example.Theater.Booking.Repository.MovieRepository;
import com.example.Theater.Booking.Repository.ShowRepository;
import com.example.Theater.Booking.Repository.TheaterRepository;
import com.example.Theater.Booking.Service.ShowService;
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
        Shows shows= Shows.builder().showType(showDTO.getShowType())
                .theaterId(theaterRepository.findById(showDTO.getTheaterId()).orElseThrow())
                .screensId(showDTO.getScreensId())
                .movieId(movieRepository.findById(showDTO.getMovieId()).orElseThrow())
                .showDate(showDTO.getShowDate()).build();
        Shows savedShowDetails= showRepository.save(shows);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"Show_Details",savedShowDetails));
    }

    public ResponseEntity<ResponseDTO> viewshows(){

        List<Shows> viewshows= showRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"Shows_List",viewshows));
    }
    }
