package com.example.Theater.Booking.controller;

import com.example.Theater.Booking.dto.PayamentDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import com.example.Theater.Booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/payment/{amount}")
    public String paymentProcess(@PathVariable String amount){
        return paymentService.paymentProcess(amount);
    }
}
