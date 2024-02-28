package com.example.Theater.Booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rewards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rewardId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "Offer_id")
    private Offers offerId;
    @Column(columnDefinition = "varchar(500)")
    private Date createdDate;
    private Date ExpiryDate;
    private String status;
    private boolean scratchStatus;
    private String linkId;
}
