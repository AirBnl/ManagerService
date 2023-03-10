package com.airbnl.managerservice.service.Implementation;

import com.airbnl.managerservice.model.Hotel;
import com.airbnl.managerservice.model.Reservation;
import com.airbnl.managerservice.service.Interfaces.IReservationService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ReservationService implements IReservationService {
    private final WebClient databaseWebClient;
    public ReservationService(WebClient databaseWebClient) {
        this.databaseWebClient = databaseWebClient;
    }
    @Override
    public Reservation save(Reservation reservation, int managerId) {
        Reservation SavedReservation = databaseWebClient.post()
                .uri("/reservation/save")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(reservation), Reservation.class)
                .retrieve()
                .bodyToMono(Reservation.class)
                .block();
        return SavedReservation;
    }
    @Override
    public List<Reservation> getAllByHotelAndManagerId(int hotelId, int managerId) {
        List<Reservation> ReservationList = databaseWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/reservation/byHotelIdAndManagerID")
                        .queryParam("hotelId", hotelId)
                        .queryParam("managerId", managerId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Reservation>>(){})
                .block();
        return ReservationList;
    }
    @Override
    public Reservation getByReservationIdAndManagerId(int reservationId, int managerId) {
        Reservation reservation = databaseWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/reservation/reservationIdAndManagerId")
                        .queryParam("reservationId", reservationId)
                        .queryParam("managerId", managerId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Reservation.class)
                .block();
        return reservation;
    }
}
