package com.bookmyshow.repository;

import com.bookmyshow.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("from Offer o join o.theatres t where lower(t.theatreName)= lower(:theatreName) " +
            "and lower(t.address.city)= lower(:city)")
    List<Offer> getOffersByCityAndTheatre(@Param("city") String city,
                                          @Param("theatreName") String theatreName);
}
