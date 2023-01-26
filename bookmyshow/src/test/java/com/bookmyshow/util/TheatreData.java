package com.bookmyshow.util;

import com.bookmyshow.entity.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
public final class TheatreData {
    public static List<Theatre> getTheatres() throws CloneNotSupportedException {


        List<Theatre> list = Arrays.asList(new Theatre(1, "PVR",
                getShows().get(0), getAddress().get(0), getOffers()), new Theatre(2, "Arena",
                getShows().get(1), getAddress().get(1), getOffers()));

        return list;
    }

    private static List<Movie> getMoviews() throws CloneNotSupportedException {
        Movie veerayya = new Movie(1, "Veerayya", "Telugu", "Action", getTickets().get(0));
        Movie mi2 = new Movie(2, "MI2", "English", "Action", getTickets().get(1));
        Movie kgf = new Movie(3, "KGF", "Kannada", "Action", getTickets().get(2));
        Movie frozen2 = new Movie(4, "FrozenII", "English", "Animation", getTickets().get(0));
        return Arrays.asList(veerayya, mi2, frozen2, kgf);
    }

    public static List<Address> getAddress() {

        Address pvrKorADdress = new Address(1, "Bangalore", "KA",
                "India", 560065, "Indiranagar", "");
        Address pvrTotalMallAddress = new Address(2, "Bangalore", "KA",
                "India", 560065, "Marathahalli", "");
        return Arrays.asList(pvrKorADdress, pvrTotalMallAddress);
    }

    public static List<List<Show>> getShows() throws CloneNotSupportedException {

        Show moeningShow = new Show(1, "Morning Show", LocalDateTime.of(2023,
                1, 10, 8, 00),
                getMoviews().get(0), null);
        Show eveningShow = new Show(1, "Evening Show", LocalDateTime.of(2023,
                1, 10, 18, 00),
                getMoviews().get(1), null);

        Show matineeShow = new Show(3, "Matinee Show", LocalDateTime.of(2023,
                1, 10, 2, 00),
                getMoviews().get(3), null);
        Show nightShow = new Show(4, "Night Show", LocalDateTime.of(2023,
                1, 10, 21, 00),
                getMoviews().get(2), null);

        return Arrays.asList(Arrays.asList(moeningShow, eveningShow), Arrays.asList(matineeShow, nightShow));
    }

    public static List<Offer> getOffers() {
        Offer offer = new Offer(1, "50% discount on the third ticket", "" +
                "Bangalore", null);
        Offer offer1 = new Offer(2, "Tickets booked for the afternoon show get a 20% discount",
                "Chennal", null);
        Offer offer2 = new Offer(3, "Tickets booked for the afternoon show get a 20% discount",
                "Bangalore", null);
        Offer offer4 = new Offer(4, "50% discount on the third ticket",
                "Chennal", null);

        return Arrays.asList(offer, offer1, offer2, offer4);
    }

    public static List<List<Ticket>> getTickets() throws CloneNotSupportedException {

        Ticket t1 = new Ticket(1, LocalDateTime.of(2023,
                1, 10, 8, 00), null);
        Ticket t2 = getTicket(t1);
//        t2.setTickeId(2);
        Ticket t3 = getTicket(t2);
//        t3.setTickeId(3);
        List<Ticket> ticketL1 = Arrays.asList(t1, t2, t3);

        Ticket ticket2 = new Ticket(4, LocalDateTime.of(2023,
                1, 10, 14, 00), null);
        t2 =getTicket(ticket2);
//        t2.setTickeId(4);
        t3 = getTicket(t2);
//        t3.setTickeId(5);
        List<Ticket> ticketL2 = Arrays.asList(t2, t3);

        Ticket ticket3 = new Ticket(3, LocalDateTime.of(2023,
                1, 10, 8, 00), null);
        t2 = getTicket(ticket3);
//        t2.setTickeId(6);
        t3 = getTicket(ticket3);
//        t3.setTickeId(7);
        Ticket t4 = getTicket(ticket3);
//        t4.setTickeId(8);
        List<Ticket> ticketL3 = Arrays.asList(t2, t3, t4);

        Ticket ticket4 = new Ticket(3, LocalDateTime.of(2023,
                1, 10, 21, 00), null);
        t2 = getTicket(ticket4);
//        t2.setTickeId(9);
        t3 = getTicket(t2);
//        t3.setTickeId(10);
        t4 = getTicket(t3);
//        t4.setTickeId(11);
//        Ticket t5 =getTicket(t4);
//        t5.setTickeId(12);
        List<Ticket> ticketL4 = Arrays.asList(t2, t3, t4, getTicket(t4));

        return Arrays.asList(ticketL1, ticketL2, ticketL3, ticketL4);
    }

    public static Ticket getTicket(Ticket ticket) throws CloneNotSupportedException {

        Ticket t = (Ticket) ticket.clone();
        t.setTickeId(ticket.getTickeId() + 1);
        return t;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        List<Theatre> theatres =  getTheatres();
        log.info("Theatres {}", theatres);

        List<Offer> offers =  getOffers();
        log.info("offers {}", offers);

        List<Movie> movies =  getMoviews();
        log.info("movies {}", movies);

    }
}
