package com.bookmyshow.dataaccess;

import com.bookmyshow.entity.Theatre;

import java.util.List;

public interface TheatreDAO {
    List<Theatre> getTheatres();
    void addOrUpdateTheatre(Theatre theatre);

    List<Theatre> getTheatres(String movieName, String city, String date);
}
