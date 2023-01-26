package com.bookmyshow.repository;

import com.bookmyshow.entity.Theatre;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.json.JSONObject;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    @Query(value = "from Theatre t join t.shows s" +
            " join address a" +
            " where t.address.addressId=a.addressId  " +
            " and lower(s.movie.name)= lower(:mname) and (a.city)= lower(:city) " +
            "and cast(s.time as date)= cast(:dayy as date)")
    List<Theatre> getTheatres(@Param("mname") String mname, @Param("city") String city,
                              @Param("dayy") String date);

}
