package edu.icet.service.Impl;

import edu.icet.dto.Feedback;
import edu.icet.dto.Item;
import edu.icet.dto.Order;
import edu.icet.entity.FeedbackEntity;
import edu.icet.entity.ItemEntity;
import edu.icet.repository.feedbackRepository;
import edu.icet.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    final feedbackRepository repository;
    final ModelMapper mapper;


    @Override
    public List<Feedback> getFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();
        repository.findAll().forEach(feedback->{
            feedbacks.add(mapper.map(feedback,Feedback.class));
        });
        return  feedbacks;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        repository.save(mapper.map(feedback, FeedbackEntity.class));
    }

    @Override
    public void deleteById(Integer feedbackId) {
        repository.deleteById(feedbackId);
    }

    @Override
    public List<Feedback> searchByFeedbackId(Integer feedbackId) {
        List<Feedback> feedbackList =new ArrayList<>();
        repository.findByFeedbackId(feedbackId).forEach(entity->{
            feedbackList.add(mapper.map(entity, Feedback.class));
        });
        return feedbackList;
    }

    @Override
    public List<Feedback> searchByCustomerId(Integer customerId) {
        List<Feedback> feedbackList =new ArrayList<>();
        repository.findByCustomerId(customerId).forEach(entity->{
            feedbackList.add(mapper.map(entity, Feedback.class));
        });
        return feedbackList;
    }
}
