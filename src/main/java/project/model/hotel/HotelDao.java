package project.model.hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by slava23 on 11/28/2016.
 */

@Transactional
@Repository
public interface HotelDao extends CrudRepository<Hotel, Integer> {
    Hotel findByName(String name);
    List<Hotel> findByCountry(String country);
    List<Hotel> findByRegion(String region);
}
