package com.bookmyshow.controller;

import com.bookmyshow.dto.TheatreDTO;
import com.bookmyshow.service.TheatreService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theatre")
@OpenAPIDefinition
@Slf4j
public class TheatreController {
    @Autowired
    @Qualifier("theatreService")
    private TheatreService theatreService;

    @Operation
    @GetMapping("/")
    public ResponseEntity<List<TheatreDTO>> getTheatres(@RequestParam String movieName,
                                                        @RequestParam String city,
                                                        @RequestParam String date) {
        log.info("Movie Name: {} City: {}, Date: {}", movieName, city, date);
        return new ResponseEntity<List<TheatreDTO>>(theatreService.getTheatres(movieName, city,
                date), HttpStatus.OK);
    }

    @OpenAPI30
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public ResponseEntity<String> addTheatre(@RequestBody TheatreDTO theatreDTO) {
        theatreService.addOrUpdateTheatre(theatreDTO);
        return new ResponseEntity<>("Theatre Added Successfully!!", HttpStatus.CREATED);
    }

    @OpenAPI30
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Transactional
    public ResponseEntity<String> updateTheatre(@RequestBody TheatreDTO theatreDTO) {
        theatreService.addOrUpdateTheatre(theatreDTO);
        return new ResponseEntity<>("Theatre Updated Successfully!!", HttpStatus.CREATED);
    }

}
