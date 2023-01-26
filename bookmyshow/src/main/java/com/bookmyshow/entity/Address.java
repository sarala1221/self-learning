package com.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Table(name = "ADDRESS")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private long pin;
    @Column(nullable = false)
    private String street;
    @Column(name = "LANDMARK")
    private String landmark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getAddressId() != address.getAddressId()) return false;
        if (getPin() != address.getPin()) return false;
        if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) return false;
        if (getState() != null ? !getState().equals(address.getState()) : address.getState() != null) return false;
        if (getCountry() != null ? !getCountry().equals(address.getCountry()) : address.getCountry() != null)
            return false;
        if (getStreet() != null ? !getStreet().equals(address.getStreet()) : address.getStreet() != null) return false;
        return getLandmark() != null ? getLandmark().equals(address.getLandmark()) : address.getLandmark() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getAddressId() ^ (getAddressId() >>> 32));
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (int) (getPin() ^ (getPin() >>> 32));
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getLandmark() != null ? getLandmark().hashCode() : 0);
        return result;
    }
}
