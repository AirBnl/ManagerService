package com.airbnl.managerservice.service.Implementation;

import com.airbnl.managerservice.model.Hotel;
import com.airbnl.managerservice.service.Interfaces.IHotelService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class HotelService implements IHotelService {
    private final WebClient webClient;
    public HotelService(WebClient databaseWebClient) {
        this.webClient = databaseWebClient;
    }

    @Override
    public Hotel save(Hotel hotel) {
        Hotel savedHotel = webClient.post()
                .uri("/hotel/save")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(hotel), Hotel.class)
                .retrieve()
                .bodyToMono(Hotel.class)
                .block();
        return savedHotel;
    }

    @Override
    public List<Hotel> getAllByManagerID(int managerId) {
        List<Hotel> hotelsList = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hotel/ByManagerID")
                        .queryParam("managerId", managerId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Hotel>>(){})
                .block();
        return hotelsList;
    }

    @Override
    public Hotel getByHotelIdAndManagerId(int hotelId, int managerId) {
        Hotel hotel = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hotel/byHotelIdAndManagerID")
                        .queryParam("hotelId", hotelId)
                        .queryParam("managerId", managerId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Hotel.class)
                .block();
        return hotel;
    }

    @Override
    public Hotel update(Hotel hotel) {
        Hotel updatedHotel = webClient.put()
                .uri("/hotel/update")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(hotel), Hotel.class)
                .retrieve()
                .bodyToMono(Hotel.class)
                .block();
        return updatedHotel;
    }

    @Override
    public Hotel deleteByIdAndManagerID(int hotelId, int managerId) {
        Hotel deletedHotel = webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path("/hotel/delete")
                        .queryParam("hotelId", hotelId)
                        .queryParam("managerId", managerId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Hotel.class)
                .block();
        return deletedHotel;
    }
}
