package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MOVIE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable , Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mid;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "LANGUAGE", nullable = false)
    private String language;
    @Column(name = "GENRE", nullable = false)
    private String genre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Ticket.class)
    @JoinColumn(name = "mid", nullable = false, updatable = true,
            insertable = true, referencedColumnName = "mid")
    private List<Ticket> tickets;

}
