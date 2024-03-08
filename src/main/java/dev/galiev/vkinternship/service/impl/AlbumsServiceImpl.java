package dev.galiev.vkinternship.service.impl;

import dev.galiev.vkinternship.dto.album.Album;
import dev.galiev.vkinternship.service.AlbumsService;
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
public class AlbumsServiceImpl implements AlbumsService {

    private final WebClient client;

    public AlbumsServiceImpl() {
        this.client = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "dev.galiev.vkinternship")
                .build();
    }

    @Override
    public ResponseEntity<List<Album>> getAlbums() {
        ResponseEntity<Album[]> response = client.get()
                .retrieve()
                .toEntity(Album[].class)
                .block();
        return new ResponseEntity<>(Arrays.stream(response.getBody()).toList(), response.getStatusCode());

    }

    @Override
    public ResponseEntity<Album> getAlbum(Integer id) {
        return client.get()
                .uri(id.toString())
                .retrieve()
                .toEntity(Album.class)
                .block();
    }

    @Override
    public ResponseEntity<Album> create(Album al) {
        return client.post()
                .bodyValue(BodyInserters.fromValue(al))
                .retrieve()
                .toEntity(Album.class)
                .block();
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return client.method(HttpMethod.DELETE)
                .uri(id.toString())
                .bodyValue(BodyInserters.fromValue(getAlbum(id).getBody()))
                .retrieve()
                .toEntity(Void.class)
                .block();
    }

    @Override
    public ResponseEntity<Album> edit(Integer id, Album album) {
        return client.put()
                .uri(id.toString())
                .body(BodyInserters.fromValue(album))
                .retrieve()
                .toEntity(Album.class)
                .block();
    }
}
