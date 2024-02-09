package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.MovieDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaterManagement/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/addmovie")
    public ResponseEntity<ResponseDTO> addmovie(@RequestBody MovieDTO movieDTO){
      return movieService.addmovie(movieDTO);
    }
    @GetMapping("/movieslist")
    public ResponseEntity<ResponseDTO> movielist(){
        return movieService.movielist();
    }
}
