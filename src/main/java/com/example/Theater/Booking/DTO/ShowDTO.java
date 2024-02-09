package com.example.Theater.Booking.DTO;

import com.example.Theater.Booking.Model.Movie;
import com.example.Theater.Booking.Model.Theater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowDTO {

    private String showType;
    private long theaterId;
    private String screensId;
    private long movieId;
    private Date showDate;
}