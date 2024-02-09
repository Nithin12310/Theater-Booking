package com.example.Theater.Booking.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDTO {

    private long theaterId;
    private String theaterName;
    private String screenName;
    private String Facilities;
}
