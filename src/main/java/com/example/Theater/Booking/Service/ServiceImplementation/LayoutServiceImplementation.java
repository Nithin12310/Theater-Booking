package com.example.Theater.Booking.Service.ServiceImplementation;

import com.example.Theater.Booking.DTO.GetLayoutDTO;
import com.example.Theater.Booking.DTO.LayoutDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.DTO.SeatClassificationDTO;
import com.example.Theater.Booking.Model.Booking;
import com.example.Theater.Booking.Model.Layouts;
import com.example.Theater.Booking.Model.Seat;
import com.example.Theater.Booking.Model.Shows;
import com.example.Theater.Booking.Model.Theater;
import com.example.Theater.Booking.Repository.BookingRepository;
import com.example.Theater.Booking.Repository.LayoutRepository;
import com.example.Theater.Booking.Repository.SeatRepository;
import com.example.Theater.Booking.Repository.ShowRepository;
import com.example.Theater.Booking.Repository.TheaterRepository;
import com.example.Theater.Booking.Service.LayoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LayoutServiceImplementation implements LayoutService {
    private final LayoutRepository layoutRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public LayoutServiceImplementation(LayoutRepository layoutRepository, BookingRepository bookingRepository) {
        this.layoutRepository = layoutRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public ResponseEntity<ResponseDTO> addlayout(LayoutDTO layoutDTO) {

        System.out.println(layoutDTO.toString());
        SeatClassificationDTO seatClassificationDTO = new SeatClassificationDTO();
        seatClassificationDTO.setSeatType(layoutDTO.getSeatDto().getSeatType());
        seatClassificationDTO.setRange(layoutDTO.getSeatDto().getRange());
        seatClassificationDTO.setSeatPrice(layoutDTO.getSeatDto().getSeatPrice());

        int layout[][] = layoutDTO.getLayout();
        String[][] arr = new String[layout.length][layout[0].length];

        char[] x = new char[arr.length];
        int m = 0;
        int fl = 0;
        while (m < seatClassificationDTO.getRange().length) {
            String temp = seatClassificationDTO.getRange()[m];

            char a = temp.toCharArray()[0];

            char b = temp.toCharArray()[2];

            while (a <= b) {
                x[m] = a;
                a++;
                m++;
            }
            fl++;

        }

//        for (char h : x) {
//            System.out.println(h + " ");
//        }

        int val=0;
        Boolean atLeastOneSeat=false;
        for (int i = 0; i < layout.length; i++) {
            int count = 1;
            atLeastOneSeat=false;
            for (int j = 0; j < layout[0].length; j++) {
                if (layout[i][j] == 1) {
                    arr[i][j] = "" + x[val] + count;
                    atLeastOneSeat=true;
                    count++;

                } else
                    arr[i][j] = "-1";

                System.out.println(i + " " + j);
            }

            if(atLeastOneSeat)
            val++;
        }
        //
        Layouts layouts = Layouts.builder().theaterId(layoutDTO.getTheaterId()).screenId(layoutDTO.getScreenId())
                .layout(arr).seatClassificcationDto(seatClassificationDTO).build();
        //
        System.out.println(layouts.toString());
        Layouts savedLayouts = layoutRepository.save(layouts);
        System.out.println(savedLayouts.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(HttpStatus.OK, "Adding_Layout", "savedLayouts"));
    }

    @Override
    public ResponseEntity<ResponseDTO> getLayout(GetLayoutDTO getLayoutDTO) throws NumberFormatException {

        Theater theatreId = theaterRepository.findById(getLayoutDTO.getTheaterId()).get();
        String screenId = getLayoutDTO.getScreenId();
        Date showDate = getLayoutDTO.getShowDate();
//        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        log.info("showDate:"+showDate);
        log.info("date:"+showDate);


            //System.out.println( showDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

//        log.info(String.valueOf(new Time(showTime.getTime())));


        Optional<List<Shows>> shows = showRepository.findAllByTheaterIdAndScreensIdAndShowDate(theatreId,
                screenId,showDate);

//
//        Optional<List<Shows>> shows = showRepository.findAllByTheaterIdAndScreensIdAndShowDate(theatreId,
//                screenId,showDate);
        System.out.println("Control");
//        LinkedHashSet<String> seatList = new LinkedHashSet<>();


        List<Booking> bookings=new ArrayList<>();

        for(Shows i:shows.get())
        {
          bookings.addAll(bookingRepository.findAllByShowId(i));
        }

        List<Seat> seatList=new ArrayList<>();
        for(Booking i:bookings)
        {
            seatList.addAll(seatRepository.findByBookingId(i));
        }

//         seatRepository.findByBookingId(bookingRepository.findByShowId(shows.get().get(0))).stream()
//                .forEach(j -> seatList.add(j.getSeatNumber()));



        Layouts layouts = layoutRepository.findByTheaterIdAndScreenId(theatreId.getTheaterId(), Long.parseLong(screenId));
        System.out.println("layouts" + layouts);
        String[][] brr = layouts.getLayout();

        for (Seat seat : seatList) {
            String[] arr = seat.getSeatNumber().split("-");

            brr[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = "0";

        }

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "layout sent", brr));

    }
}
