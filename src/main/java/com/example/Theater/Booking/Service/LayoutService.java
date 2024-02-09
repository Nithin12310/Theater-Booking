package com.example.Theater.Booking.Service;

import com.example.Theater.Booking.DTO.GetLayoutDTO;
import com.example.Theater.Booking.DTO.LayoutDTO;
import com.example.Theater.Booking.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

@Service
public interface LayoutService {

    public ResponseEntity<ResponseDTO> addlayout(LayoutDTO layoutDTO);

    public ResponseEntity<ResponseDTO> getLayout(GetLayoutDTO getLayoutDTO) throws NumberFormatException;

}
