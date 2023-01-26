package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "OFFER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "oid")
    private long offerId;

    @Column(name = "DESCR", length = 1000)
    private String descr;

    @Column
    private String city;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "offer_theatres",
            joinColumns = @JoinColumn(name = "oid"),
            inverseJoinColumns = @JoinColumn(name = "tid"))
    private List<Theatre> theatres;

}
