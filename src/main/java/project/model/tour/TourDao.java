package project.model.tour;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by slava23 on 12/3/2016.
 */
public interface TourDao extends CrudRepository<Tour, Integer> {
    List<Tour> findAll();
}
