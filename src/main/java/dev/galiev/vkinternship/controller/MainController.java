package dev.galiev.vkinternship.controller;

import dev.galiev.vkinternship.dao.user.User;
import dev.galiev.vkinternship.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private UserRepository users;

    @GetMapping("/")
    public List<User> getUsers() {
        return users.findAll();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return users.save(user);
    }
}
