package dev.galiev.vkinternship.repository;

import dev.galiev.vkinternship.dao.user.Geo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends CrudRepository<Geo, Long> {
}
