package com.bookmyshow.service;

import com.bookmyshow.dto.TheatreDTO;

import java.util.List;

public interface TheatreService {

    void addOrUpdateTheatre(TheatreDTO theatreDTO);

    List<TheatreDTO> getTheatres(String movieName, String city, String date);
}
