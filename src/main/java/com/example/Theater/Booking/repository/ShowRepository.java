package com.example.Theater.Booking.repository;

import com.example.Theater.Booking.model.Shows;
import com.example.Theater.Booking.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Shows, Long> {


    Optional<List<Shows>> findAllByTheaterIdAndScreensId(Theater theatreId, String screenId);

    Optional<List<Shows>> findAllByTheaterIdAndScreensIdAndShowDate(Theater theatreId, String screenId,
                                                                    Date showDate);

}
