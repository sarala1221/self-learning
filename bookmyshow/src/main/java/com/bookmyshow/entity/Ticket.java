package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TICKET")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Serializable, Cloneable {

    @Id
    @Column(name = "TICKET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tickeId;

    @Column(name = "SHOW_TIME")
    private LocalDateTime time;

    @ManyToOne
    private Movie movie;

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
