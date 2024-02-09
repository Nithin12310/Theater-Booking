package com.example.Theater.Booking.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Document(collection = "Theater_Information")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int screenId;
    private long theaterId;
    private String theaterName;
    private String screenName;
    private String Facilities;
}
