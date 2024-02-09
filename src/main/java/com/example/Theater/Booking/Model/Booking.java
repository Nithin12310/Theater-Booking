package com.example.Theater.Booking.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    @ManyToOne()
    @JoinColumn(name = "show_id")
    private Shows showId;
    private String showType;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User userid;
    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movieId;
    private String movieName;

    @DateTimeFormat()
    private Time showStartTime;
    private Time showEndTime;
    private String status;
    private Date bookedDate;







}