package edu.icet.controller;


import edu.icet.dto.Feedback;
import edu.icet.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController {
    final FeedbackService feedbackService;

    @GetMapping("/get-all")
    public List<Feedback> getFeedback() {
        return feedbackService.getFeedback();
    }

    @PostMapping("/add-feedback")
    public void addFeedback(@RequestBody Feedback feedback) {
        feedbackService.addFeedback(feedback);
    }

    @DeleteMapping("/delete-by-id/{feedbackId}")
    public void deleteById(@PathVariable Integer feedbackId) {
        feedbackService.deleteById(feedbackId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateFeedback(@RequestBody Feedback feedback) {
        feedbackService.addFeedback(feedback);
    }


    @GetMapping("/get-feedback-by-Id/{feedbackId}")
    public List<Feedback> getByFeedbackId(@PathVariable Integer feedbackId){
        return feedbackService.searchByFeedbackId(feedbackId);
    }

    @GetMapping("/get-feedback-by-customerId/{customerId}")
    public List<Feedback> getByCustomerId(@PathVariable Integer customerId){
        return feedbackService.searchByCustomerId(customerId);
    }
}
