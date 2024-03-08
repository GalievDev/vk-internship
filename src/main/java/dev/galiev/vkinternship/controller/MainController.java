package dev.galiev.vkinternship.controller;

import dev.galiev.vkinternship.dto.user.User;
import dev.galiev.vkinternship.repository.UserRepository;
import dev.galiev.vkinternship.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private UserRepository users;

    @Autowired
    private UsersService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        return service.getUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable Integer id, @RequestBody User user) {
        return service.edit(id, user);
    }
}
