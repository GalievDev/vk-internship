package dev.galiev.vkinternship.service;

import dev.galiev.vkinternship.dto.user.User;
import dev.galiev.vkinternship.dto.user.Users;

public interface UsersService {
    Users getUsers();
    User getUserById(Integer id);
    User create(User user);
    User delete(User user);
    User delete(Integer id);
    User edit(User user);
    User edit(Integer id);
}
