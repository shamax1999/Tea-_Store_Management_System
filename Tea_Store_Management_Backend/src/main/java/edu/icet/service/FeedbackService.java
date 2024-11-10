package edu.icet.service;

import edu.icet.dto.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getFeedback();

    void addFeedback(Feedback feedback);

    void deleteById(Integer feedbackId);

    List<Feedback> searchByFeedbackId(Integer feedbackId);

    List<Feedback> searchByCustomerId(Integer customerId);

}
