package com.example.Theater.Booking.Model;


import com.example.Theater.Booking.DTO.SeatClassificationDTO;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Theater_Layout")
public class Layouts {
    @Id
    private String id;
    private long theaterId;
    private long screenId;
    private String layout[][];
    private SeatClassificationDTO seatClassificcationDto;

}
