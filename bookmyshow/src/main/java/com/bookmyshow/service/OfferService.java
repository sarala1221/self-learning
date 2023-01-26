package com.bookmyshow.service;

import com.bookmyshow.dto.OfferDTO;
import com.bookmyshow.entity.Offer;

import java.util.List;

public interface OfferService {
    List<OfferDTO> getOffers(String city, String theatreName);

    void addOffers(List<OfferDTO> offers);
}
