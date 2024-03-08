package dev.galiev.vkinternship.service.impl;

import dev.galiev.vkinternship.dto.post.Post;
import dev.galiev.vkinternship.service.PostsService;
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
public class PostsServiceImpl implements PostsService {

    private final WebClient client;

    public PostsServiceImpl() {
        this.client = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "dev.galiev.vkinternship")
                .build();
    }

    @Override
    public ResponseEntity<List<Post>> getPosts() {
        ResponseEntity<Post[]> response = client.get()
                .retrieve()
                .toEntity(Post[].class)
                .block();
        return new ResponseEntity<>(Arrays.stream(response.getBody()).toList(), response.getStatusCode());

    }

    @Override
    public ResponseEntity<Post> getPost(Integer id) {
        return client.get()
                .uri(id.toString())
                .retrieve()
                .toEntity(Post.class)
                .block();
    }

    @Override
    public ResponseEntity<Post> create(Post post) {
        return client.post()
                .bodyValue(BodyInserters.fromValue(post))
                .retrieve()
                .toEntity(Post.class)
                .block();
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return client.method(HttpMethod.DELETE)
                .uri(id.toString())
                .bodyValue(BodyInserters.fromValue(getPost(id).getBody()))
                .retrieve()
                .toEntity(Void.class)
                .block();
    }

    @Override
    public ResponseEntity<Post> edit(Integer id, Post post) {
        return client.put()
                .uri(id.toString())
                .body(BodyInserters.fromValue(post))
                .retrieve()
                .toEntity(Post.class)
                .block();
    }
}
