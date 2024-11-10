package edu.icet.repository;

import edu.icet.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface feedbackRepository extends JpaRepository<FeedbackEntity, Integer> {
    List<FeedbackEntity> findByFeedbackId(Integer feedbackId);

    List<FeedbackEntity> findByCustomerId(Integer customerId);

}
