package com.bookmyshow.dataaccess.impl;

import com.bookmyshow.dataaccess.TheatreDAO;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("theatreDAO")
public class TheatreDAOImpl implements TheatreDAO {

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public void addOrUpdateTheatre(Theatre theatre) {
        theatreRepository.save(theatre);
    }

    @Override
    public List<Theatre> getTheatres() {
        try {
            return theatreRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Theatre> getTheatres(String movieName, String city, String date) {
        try{
            List<Theatre> t = theatreRepository.getTheatres(movieName,city,date);
            System.out.println(t);
            return t;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }


    }


}
