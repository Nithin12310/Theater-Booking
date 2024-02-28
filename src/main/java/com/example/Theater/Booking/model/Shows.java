package com.example.Theater.Booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showId;
    private String showType;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theaterId;
    private String screensId;
    @ManyToOne
    @JoinColumn(name = "movie")
    private Movie movieId;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date showDate;
}
