package dev.galiev.vkinternship.controller;

import dev.galiev.vkinternship.dto.post.Post;
import dev.galiev.vkinternship.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    @Autowired
    private PostsService service;

    @PostMapping("/")
    public ResponseEntity<Post> create(@RequestBody dev.galiev.vkinternship.dto.post.Post pos) {
        return service.create(pos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        return service.getPost(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getPosts() {
        return service.getPosts();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> editUser(@PathVariable Integer id, @RequestBody Post post) {
        return service.edit(id, post);
    }
}
