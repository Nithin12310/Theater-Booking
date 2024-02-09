package com.example.Theater.Booking.Service.ServiceImplementation;

import com.example.Theater.Booking.DTO.MovieDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.Model.Movie;
import com.example.Theater.Booking.Repository.MovieRepository;
import com.example.Theater.Booking.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public ResponseEntity<ResponseDTO> addmovie(MovieDTO movieDTO) {
        Movie movie= Movie.builder().movieName(movieDTO.getMovieName()).about(movieDTO.getAbout()).duration(movieDTO.getDuration()).build();
        Movie savedMovieDetails=movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"Movie_Details",savedMovieDetails));
    }

    @Override
    public ResponseEntity<ResponseDTO> movielist() {
        List<Movie> movies= movieRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"Movie_List",movies));
    }
}
