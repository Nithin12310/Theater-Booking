package com.example.Theater.Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowWithMovieNameProjection {

    private Time startTime;
    private String movieName;
}
