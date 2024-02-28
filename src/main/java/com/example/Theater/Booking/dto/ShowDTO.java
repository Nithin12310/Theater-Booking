package com.example.Theater.Booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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