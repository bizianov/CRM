package project.model.hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by slava23 on 11/28/2016.
 */

@Transactional
@Repository
public interface HotelDao extends CrudRepository<Hotel, Integer> {
}
