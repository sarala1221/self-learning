package com.bookmyshow.dto;

import com.bookmyshow.entity.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ShowDTO {
    private long id;
    private String name;
    private LocalDateTime time;
    private MovieDTO movie;

}
