package com.example.Theater.Booking.Repository;

import com.example.Theater.Booking.Model.Shows;
import com.example.Theater.Booking.Model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Shows,Long> {


    Optional<List<Shows>> findAllByTheaterIdAndScreensId(Theater theatreId, String screenId);

    Optional<List<Shows>> findAllByTheaterIdAndScreensIdAndShowDate(Theater theatreId, String screenId,
                                                                    Date showDate);

//    Optional<List<Shows>> findAllByTheaterIdAndScreensIdAndStartTime(Theater theatreId, String screenId, LocalTime showTime);
}
