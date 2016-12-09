package project.model.passport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by slava23 on 11/29/2016.
 */

@Repository
@Transactional
public interface PassportDao extends CrudRepository<Passport, Integer> {
}
