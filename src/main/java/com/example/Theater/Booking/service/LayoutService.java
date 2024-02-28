package com.example.Theater.Booking.service;

import com.example.Theater.Booking.dto.GetLayoutDTO;
import com.example.Theater.Booking.dto.LayoutDTO;
import com.example.Theater.Booking.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LayoutService {

    public ResponseEntity<ResponseDTO> addlayout(LayoutDTO layoutDTO);

    public ResponseEntity<ResponseDTO> getLayout(GetLayoutDTO getLayoutDTO) throws NumberFormatException;

}
