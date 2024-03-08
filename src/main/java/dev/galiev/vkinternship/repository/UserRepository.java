package dev.galiev.vkinternship.repository;

import dev.galiev.vkinternship.dao.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
