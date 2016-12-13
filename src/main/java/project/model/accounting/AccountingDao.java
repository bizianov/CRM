package project.model.accounting;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by slava23 on 12/10/2016.
 */

@Repository
public interface AccountingDao extends CrudRepository<Accounting, Integer> {
}
