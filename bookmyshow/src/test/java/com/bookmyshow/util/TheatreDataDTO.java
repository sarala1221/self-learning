package com.bookmyshow.util;

import com.bookmyshow.dto.*;
import com.bookmyshow.entity.Offer;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
public final class TheatreDataDTO {
    public static List<TheatreDTO> getTheatres() throws CloneNotSupportedException {


        List<TheatreDTO> list = Arrays.asList(new TheatreDTO(1, "PVR",
                getShows().get(0), getAddress().get(0), getOffers()), new TheatreDTO(2, "Arena",
                getShows().get(1), getAddress().get(1), getOffers()));

        return list;
    }

    private static List<MovieDTO> getMoviews() throws CloneNotSupportedException {
        MovieDTO veerayya = new MovieDTO(1, "Veerayya", "Telugu", "Action", getTickets().get(0));
        MovieDTO mi2 = new MovieDTO(2, "MI2", "English", "Action", getTickets().get(1));
        MovieDTO kgf = new MovieDTO(3, "KGF", "Kannada", "Action", getTickets().get(2));
        MovieDTO frozen2 = new MovieDTO(4, "FrozenII", "English", "Animation", getTickets().get(0));
        return Arrays.asList(veerayya, mi2, frozen2, kgf);
    }

    public static List<AddressDTO> getAddress() {

        AddressDTO pvrKorADdress = new AddressDTO(1, "Bangalore", "KA",
                "India", 560065, "Indiranagar", "");
        AddressDTO pvrTotalMallAddress = new AddressDTO(2, "Bangalore", "KA",
                "India", 560065, "Marathahalli", "");
        return Arrays.asList(pvrKorADdress, pvrTotalMallAddress);
    }

    public static List<List<ShowDTO>> getShows() throws CloneNotSupportedException {

        ShowDTO moeningShow = new ShowDTO(1l, "Morning Show", LocalDateTime.of(2023,
                1, 10, 8, 00),
                getMoviews().get(0));

        ShowDTO eveningShow = new ShowDTO(2l, "Evening Show", LocalDateTime.of(2023,
                1, 10, 18, 00),
                getMoviews().get(1));

        ShowDTO matineeShow = new ShowDTO(3, "Matinee Show", LocalDateTime.of(2023,
                1, 10, 2, 00),
                getMoviews().get(3));
        ShowDTO nightShow = new ShowDTO(4, "Night Show", LocalDateTime.of(2023,
                1, 10, 21, 00),
                getMoviews().get(2));

        return Arrays.asList(Arrays.asList(moeningShow, eveningShow), Arrays.asList(matineeShow, nightShow));
    }

    public static List<OfferDTO> getOffers() {
        OfferDTO offer = new OfferDTO(1, "50% discount on the third ticket", "" +
                "Hyderabad", null);
        OfferDTO offer1 = new OfferDTO(2, "Tickets booked for the afternoon show get a 20% discount",
                "Chennai", null);
        OfferDTO offer2 = new OfferDTO(3, "Tickets booked for the afternoon show get a 20% discount",
                "Bangalore", null);
        OfferDTO offer4 = new OfferDTO(4, "50% discount on the third ticket",
                "Pune", null);

        return Arrays.asList(offer, offer1, offer2, offer4);
    }

    public static List<List<TicketDTO>> getTickets() throws CloneNotSupportedException {

        TicketDTO t1 = new TicketDTO(1, LocalDateTime.of(2023,
                1, 10, 8, 00), null);
        TicketDTO t2 = getTicket(t1);
//        t2.setTickeId(2);
        TicketDTO t3 = getTicket(t2);
//        t3.setTickeId(3);
        List<TicketDTO> ticketL1 = Arrays.asList(t1, t2, t3);

        TicketDTO ticket2 = new TicketDTO(4, LocalDateTime.of(2023,
                1, 10, 14, 00), null);
        t2 =getTicket(ticket2);
//        t2.setTickeId(4);
        t3 = getTicket(t2);
//        t3.setTickeId(5);
        List<TicketDTO> ticketL2 = Arrays.asList(t2, t3);

        TicketDTO ticket3 = new TicketDTO(3, LocalDateTime.of(2023,
                1, 10, 8, 00), null);
        t2 = getTicket(ticket3);
//        t2.setTickeId(6);
        t3 = getTicket(ticket3);
//        t3.setTickeId(7);
        TicketDTO t4 = getTicket(ticket3);
//        t4.setTickeId(8);
        List<TicketDTO> ticketL3 = Arrays.asList(t2, t3, t4);

        TicketDTO ticket4 = new TicketDTO(3, LocalDateTime.of(2023,
                1, 10, 21, 00), null);
        t2 = getTicket(ticket4);
//        t2.setTickeId(9);
        t3 = getTicket(t2);
//        t3.setTickeId(10);
        t4 = getTicket(t3);
//        t4.setTickeId(11);
//        Ticket t5 =getTicket(t4);
//        t5.setTickeId(12);
        List<TicketDTO> ticketL4 = Arrays.asList(t2, t3, t4, getTicket(t4));

        return Arrays.asList(ticketL1, ticketL2, ticketL3, ticketL4);
    }

    public static TicketDTO getTicket(TicketDTO ticket) throws CloneNotSupportedException {

        TicketDTO t = (TicketDTO) ticket.clone();
        t.setTickeId(ticket.getTickeId() + 1);
        return t;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        List<TheatreDTO> theatres =  getTheatres();
        log.info("Theatres {}", theatres);

        List<OfferDTO> offers =  getOffers();
        log.info("offers {}", offers);

        List<MovieDTO> movies =  getMoviews();
        log.info("movies {}", movies);

    }
}
