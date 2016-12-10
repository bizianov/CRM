package project.model.feedback;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by slava23 on 12/9/2016.
 */

@Repository
public interface FeedbackDao extends CrudRepository<Feedback, Integer> {
}
