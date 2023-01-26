package com.bookmyshow.dto;

import com.bookmyshow.entity.Theatre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO implements Serializable {
    private long offerId;

    private String descr;

    private String city;

    @JsonIgnore
    private List<TheatreDTO> theatres;
}
