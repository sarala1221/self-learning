package com.bookmyshow.dataaccess.impl;

import com.bookmyshow.dataaccess.OfferDAO;
import com.bookmyshow.entity.Offer;
import com.bookmyshow.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("OfferDAO")
public class OfferDAOImpl implements OfferDAO {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> getOffers(String city, String theatreName) {
        return offerRepository.getOffersByCityAndTheatre(city, theatreName);
    }

    @Override
    public void addOffers(List<Offer> offers) {
        offerRepository.saveAll(offers);
    }
}
