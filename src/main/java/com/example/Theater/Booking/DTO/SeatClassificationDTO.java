package com.example.Theater.Booking.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatClassificationDTO implements Serializable {

    @JsonProperty
    String[] seatType;

    @JsonProperty("Range")
    String[] Range;
    Integer[] seatPrice;

}
