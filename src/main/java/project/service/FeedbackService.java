package project.service;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.feedback.Feedback;
import project.model.feedback.FeedbackDao;
import project.model.hotel.Hotel;
import project.model.tourist.Tourist;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slava23 on 12/9/2016.
 */

@Service
@Data
@Slf4j
public class FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    public Feedback findFeedbackById(int id) {
        return feedbackDao.findOne(id);
    }

    public Feedback saveFeedback(Feedback feedback){
        return feedbackDao.save(feedback);
    }

    public List<Feedback> findFeedbackByTourist(Tourist tourist) {
        return tourist != null ? Lists.newArrayList(feedbackDao.findAll())
                .stream()
                .filter(feedback -> feedback.getTour().getTouristList().contains(tourist))
                .collect(Collectors.toList()) : Lists.newArrayList();

    }

    public List<Feedback> findFeedbackByHotel(Hotel hotel) {
        return hotel != null ? Lists.newArrayList(feedbackDao.findAll())
                .stream()
                .filter(feedback -> feedback.getTour().getHotel().equals(hotel))
                .collect(Collectors.toList()) : Lists.newArrayList();
    }

    public List<Feedback> findFeedbackByPeriod(LocalDate start, LocalDate end) {
        return Lists.newArrayList(feedbackDao.findAll())
                .stream()
                .filter(feedback -> feedback.getDate().isAfter(start)
                        && feedback.getDate().isBefore(end))
                .collect(Collectors.toList());
    }
}
