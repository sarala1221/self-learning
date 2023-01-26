package com.bookmyshow.dto;

import com.bookmyshow.entity.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TicketDTO implements Serializable, Cloneable {

    private long tickeId;

    private LocalDateTime time;

    private Movie movie;

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
