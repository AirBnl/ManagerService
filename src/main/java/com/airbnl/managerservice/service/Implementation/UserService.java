package com.airbnl.managerservice.service.Implementation;

import com.airbnl.managerservice.model.Hotel;
import com.airbnl.managerservice.model.Reservation;
import com.airbnl.managerservice.model.User;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

    private final WebClient webClient;
    public UserService(WebClient authWebClient) {
        this.webClient = authWebClient;
    }

    @Override
    public User save(User user) {
        User savedUser = webClient.post()
                .uri("/user/save")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        return savedUser;
    }

    @Override
    public User getByUserName(String username) {
        User userFromDb = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/user")
                        .queryParam("username", username)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        return userFromDb;
    }
}
