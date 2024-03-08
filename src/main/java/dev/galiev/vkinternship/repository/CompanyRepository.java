package dev.galiev.vkinternship.repository;

import dev.galiev.vkinternship.dao.user.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
}
