package com.hadid.book_network.mapper;

import com.hadid.book_network.dto.request.FeedbackRequest;
import com.hadid.book_network.entity.book.Book;
import com.hadid.book_network.entity.feedback.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackMapper {

    public Feedback toFeedback(FeedbackRequest feedbackRequest) {
        return Feedback.builder()
                .note(feedbackRequest.note())
                .comment(feedbackRequest.comment())
                .book(Book.builder()
                        .id(feedbackRequest.bookId())
                        .archived(false)
                        .shareable(false)
                        .build()
                )
                .build();
    }

}
