package com.example.Theater.Booking.Controller;

import com.example.Theater.Booking.DTO.PayamentDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import com.example.Theater.Booking.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/theaterManagement/payment")
public class PaymentController {
@Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<ResponseDTO> payment(@RequestBody PayamentDTO payamentDTO) throws ParseException {
        return paymentService.payment(payamentDTO);
    }
}
