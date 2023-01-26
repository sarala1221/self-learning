package com.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AddressDTO {

    private long addressId;
    private String city;
    private String state;
    private String country;
    private long pin;
    private String street;
    private String landmark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDTO address = (AddressDTO) o;

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
