package com.bookmyshow.dto;

import com.bookmyshow.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieDTO {
    private long mid;
    private String name;
    private String language;
    private String genre;
    private List<TicketDTO> tickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDTO movie = (MovieDTO) o;

        if (getMid() != movie.getMid()) return false;
        if (getName() != null ? !getName().equals(movie.getName()) : movie.getName() != null) return false;
        if (getLanguage() != null ? !getLanguage().equals(movie.getLanguage()) : movie.getLanguage() != null)
            return false;
        return getGenre() != null ? getGenre().equals(movie.getGenre()) : movie.getGenre() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getMid() ^ (getMid() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        return result;
    }
}
