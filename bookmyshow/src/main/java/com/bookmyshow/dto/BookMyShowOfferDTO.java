package com.bookmyshow.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class BookMyShowOfferDTO {
    private Long id;

    private List<String> offers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookMyShowOfferDTO that = (BookMyShowOfferDTO) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getOffers() != null ? getOffers().equals(that.getOffers()) : that.getOffers() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOffers() != null ? getOffers().hashCode() : 0);
        return result;
    }
}
