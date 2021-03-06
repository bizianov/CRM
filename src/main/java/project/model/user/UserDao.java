package project.model.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by slava23 on 10/11/2016.
 */

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findByUsername(String name);
}
