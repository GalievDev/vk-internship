package dev.galiev.vkinternship.service.impl;

import dev.galiev.vkinternship.dto.user.User;
import dev.galiev.vkinternship.service.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private final WebClient client;

    public UsersServiceImpl() {
        this.client = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/users/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "dev.galiev.vkinternship")
                .build();
    }


    @Override
    public ResponseEntity<List<User>> getUsers() {
        ResponseEntity<User[]> response = client.get()
                .retrieve()
                .toEntity(User[].class)
                .block();
        return new ResponseEntity<>(Arrays.stream(response.getBody()).toList(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<User> getUserById(Integer id) {
        return client.get()
                .uri(id.toString())
                .retrieve()
                .toEntity(User.class)
                .block();
    }

    @Override
    public ResponseEntity<User> create(User user) {
        return client.post()
                .bodyValue(BodyInserters.fromValue(user))
                .retrieve()
                .toEntity(User.class)
                .block();
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return client.method(HttpMethod.DELETE)
                .uri(id.toString())
                .body(BodyInserters.fromValue(getUserById(id).getBody()))
                .retrieve()
                .toEntity(Void.class)
                .block();
    }

    @Override
    public ResponseEntity<User> edit(Integer id, User user) {
        return client.put()
                .uri(id.toString())
                .body(BodyInserters.fromValue(user))
                .retrieve()
                .toEntity(User.class)
                .block();
    }
}
