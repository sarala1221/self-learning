package com.bookmyshow.dto;

import com.bookmyshow.entity.Offer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Data
@Setter
@Getter
@AllArgsConstructor
public class TheatreDTO {
    private long tid;
    private String theatreName;
//    @JsonIgnore
    private List<ShowDTO> shows;
//    @JsonIgnore
    private AddressDTO address;
//    @JsonIgnore
    private List<OfferDTO> offers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TheatreDTO theatre = (TheatreDTO) o;

        if (getTid() != theatre.getTid()) return false;
        if (getShows() != null ? !getShows().equals(theatre.getShows()) : theatre.getShows() != null) return false;
        return getAddress() != null ? getAddress().equals(theatre.getAddress()) : theatre.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getTid() ^ (getTid() >>> 32));
        result = 31 * result + (getShows() != null ? getShows().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }
}
