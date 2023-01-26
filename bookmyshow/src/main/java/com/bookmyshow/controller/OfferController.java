package com.bookmyshow.controller;

import com.bookmyshow.dto.OfferDTO;
import com.bookmyshow.entity.Offer;
import com.bookmyshow.service.OfferService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/platforOffers")
@OpenAPIDefinition
public class OfferController {
    @Autowired
    private OfferService offerService;

    @Operation
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> getOffers(@RequestParam String city, @RequestParam String theatreName){

        return new ResponseEntity<>(offerService.getOffers(city, theatreName), HttpStatus.OK);
    }
    @Operation
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addOffers(@RequestBody List<OfferDTO> offers){
        offerService.addOffers(offers);
        return new ResponseEntity<String>("Offer Created Successfully!!", HttpStatus.CREATED);
    }
}
