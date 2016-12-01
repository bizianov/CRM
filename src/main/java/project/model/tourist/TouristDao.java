package project.model.tourist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by slava23 on 12/1/2016.
 */

@Repository
public interface TouristDao extends CrudRepository<Tourist, Integer> {
    List<Tourist> findByFirstName(String firstName);
    List<Tourist> findByLastName(String lastName);
    Tourist findByPhone(String phone);
    Tourist findByEmail(String email);
}
