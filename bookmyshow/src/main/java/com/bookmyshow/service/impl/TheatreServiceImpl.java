package com.bookmyshow.service.impl;

import com.bookmyshow.dataaccess.impl.TheatreDAOImpl;
import com.bookmyshow.dto.TheatreDTO;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.service.TheatreService;
import com.bookmyshow.util.BookMyShowUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("theatreService")
@Slf4j
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    @Qualifier("theatreDAO")
    private TheatreDAOImpl theatreDAO;


    @Override
    public List<TheatreDTO> getTheatres(@NotNull String movieName, @NotNull String city,
                                        @NotNull String date) {

        try{

            List<Theatre> theatres = theatreDAO.getTheatres(movieName,city,date);
            log.info("theatres  {}", theatres.size());
            return BookMyShowUtil.mapper().convertValue(theatres,
                    new TypeReference<List<TheatreDTO>>() {
                    });
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }

    }
    @Override
    public void addOrUpdateTheatre(TheatreDTO theatreDTO) {
        Theatre theatre = BookMyShowUtil.mapper().convertValue(theatreDTO, Theatre.class);
        log.info("theatre >> {}", theatre.getTheatreName());
        theatreDAO.addOrUpdateTheatre(theatre);
    }

}
