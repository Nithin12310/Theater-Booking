package com.example.Theater.Booking.Model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "LinkType_Offers")
public class LinkTypeOffer {

    @Id
    private String id;
    private String link;
    private boolean publish;

}
