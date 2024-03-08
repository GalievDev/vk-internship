package dev.galiev.vkinternship.repository;

import dev.galiev.vkinternship.dao.user.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
