package com.bookmyshow.dao;

import com.bookmyshow.entity.Offer;
import com.bookmyshow.repository.OfferRepository;
import com.bookmyshow.util.TheatreData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OfferDAOTest {

    @MockBean
    private OfferRepository offerRepository;

    @Test
    public void testAddOffers() {
        offerRepository.saveAll(TheatreData.getOffers());
        verify(offerRepository, times(1)).saveAll(any());
    }

    @Test
    public void testOffers() {

        List<Offer> offers = TheatreData.getOffers();
        when(offerRepository.getOffersByCityAndTheatre(any(), any())).thenReturn(offers);
        offerRepository.getOffersByCityAndTheatre("Bangalore", "PVR");
        verify(offerRepository, times(1)).getOffersByCityAndTheatre(any(), any());
        assertEquals("Bangalore", offers.get(0).getCity());
    }

    @Test
    public void testOffer() {

        List<Offer> offers = new ArrayList<>();
        when(offerRepository.getOffersByCityAndTheatre(any(), any())).thenReturn(offers);
        offerRepository.getOffersByCityAndTheatre("Delhi", "Central");
        verify(offerRepository, times(1)).getOffersByCityAndTheatre(any(), any());
        assertEquals(0, offers.size());
    }

}
