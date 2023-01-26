package com.bookmyshow.service.impl;

import com.bookmyshow.dataaccess.OfferDAO;
import com.bookmyshow.dto.OfferDTO;
import com.bookmyshow.entity.Offer;
import com.bookmyshow.service.OfferService;
import com.bookmyshow.util.BookMyShowUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("offerService")
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferDAO offerDAO;

    @Override
    public List<OfferDTO> getOffers(String city, String theatreName) {

        return BookMyShowUtil.mapper().convertValue(offerDAO.getOffers(city, theatreName),
                new TypeReference<List<OfferDTO>>() {
                });
    }

    @Override
    public void addOffers(List<OfferDTO> offers) {
        try {
            offerDAO.addOffers(BookMyShowUtil.mapper().convertValue(offers,
                    new TypeReference<List<Offer>>() {
            }));
        } catch (Exception e) {
            throw e;
        }
    }
}
