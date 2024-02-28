package com.example.Theater.Booking.service.serviceImplementation;

import com.example.Theater.Booking.dto.BookingDTO;
import com.example.Theater.Booking.dto.BookingDetailsDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.dto.SeatDTO;
import com.example.Theater.Booking.model.Booking;
import com.example.Theater.Booking.model.Seat;
import com.example.Theater.Booking.repository.*;
import com.example.Theater.Booking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImplementation implements BookingService {
    final ShowRepository showRepository;
    final UserRepository userRepository;
    final MovieRepository movieRepository;
    final BookingRepository bookingRepository;
    final SeatRepository seatRepository;

    public BookingServiceImplementation(ShowRepository showRepository, UserRepository userRepository,
                                        MovieRepository movieRepository, BookingRepository bookingRepository, SeatRepository seatRepository) {
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public ResponseEntity<ResponseDTO> book(BookingDTO bookingDTO) {

        Booking booking = Booking.builder().showId(showRepository.findById(bookingDTO.getShowId()).orElseThrow())
                .showType(bookingDTO.getShowType())
                .userid(userRepository.findById(bookingDTO.getUserid()).orElseThrow())
                .movieId(movieRepository.findById(bookingDTO.getMovieId()).orElseThrow())
                .movieName(bookingDTO.getMovieName())
                .showStartTime(bookingDTO.getShowStartTime())
                .showEndTime(bookingDTO.getShowEndTime())
                .bookedDate(new Date())
                .status(bookingDTO.getStatus())
                .build();
        Booking savedBooking = bookingRepository.save(booking);
        List<Seat> savedSeat = new ArrayList<>();
        for (SeatDTO seatDTO : bookingDTO.getSeats()) {
            Seat seat = Seat.builder().seatNumber(seatDTO.getSeatNumber())
                    .seatType(seatDTO.getSeatType())
                    .bookingId(savedBooking)
                    .build();
            seatRepository.save(seat);
            savedSeat.add(seat);


        }


        BookingDetailsDTO bookingDetailsDTO = new BookingDetailsDTO();
        bookingDetailsDTO.setBooking(savedBooking);
        bookingDetailsDTO.setSeats(savedSeat);


        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Booking_Tickets", bookingDetailsDTO));
    }

    //@Scheduled(fixedDelay = 1000)
    public void checkingBlockStatus() {
        List<Booking> booking = bookingRepository.findAll();
        // System.out.println(booking);
        Date date = new Date();
        for (Booking booking1 : booking) {
            if (booking1.getStatus().equals("block")) {

                if (date.getTime() - booking1.getBookedDate().getTime() > 120000)
                    booking1.setStatus("UnBlocked");
                // System.out.println("called");
                bookingRepository.save(booking1);
            }
        }
    }
}
