package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "THEATRE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theatre implements Serializable {
    @Id
    @Column(name = "TID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tid;

    @Column(name = "NAME", nullable = false, unique = true)
    private String theatreName;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Show.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tid", nullable = false, updatable = true, insertable = true, referencedColumnName = "TID")
    private List<Show> shows;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "offer_theatres",
            joinColumns = @JoinColumn(name = "tid"),
            inverseJoinColumns = @JoinColumn(name = "oid"))
    private List<Offer> offers;

}
