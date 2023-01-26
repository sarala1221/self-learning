package com.bookmyshow.dataaccess;

import com.bookmyshow.entity.Offer;

import java.util.List;

public interface OfferDAO {

    List<Offer> getOffers(String city, String theatreName);

    void addOffers(List<Offer> offers);
}
