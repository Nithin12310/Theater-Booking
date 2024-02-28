package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.PayamentDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface PaymentService {


    public ResponseEntity<ResponseDTO> payment(PayamentDTO payamentDTO) throws ParseException;

    String paymentProcess(String amount);
}
