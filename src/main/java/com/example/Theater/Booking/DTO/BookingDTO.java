package com.example.Theater.Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private long showId;
    private String showType;
    private long userid;
    private long movieId;
    private String movieName;
    private List<SeatDTO> seats;
    private Time showStartTime;
    private Time showEndTime;
    private Date bookedDate;
    private String status;


}
