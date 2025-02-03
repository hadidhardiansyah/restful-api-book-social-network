package com.hadid.book_network.service.implementation;

import com.hadid.book_network.dto.request.FeedbackRequest;
import com.hadid.book_network.entity.book.Book;
import com.hadid.book_network.entity.feedback.Feedback;
import com.hadid.book_network.entity.user.User;
import com.hadid.book_network.exception.OperationNotPermittedException;
import com.hadid.book_network.mapper.FeedbackMapper;
import com.hadid.book_network.repository.IBookRepository;
import com.hadid.book_network.repository.IFeedbackRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final IBookRepository bookRepository;

    private final IFeedbackRepository feedbackRepository;

    private final FeedbackMapper feedbackMapper;

    public Long save(FeedbackRequest feedbackRequest, Authentication connectedUser) {
        Book book = bookRepository.findById(feedbackRequest.bookId())
                .orElseThrow(() -> new EntityNotFoundException("No book found with ID: " + feedbackRequest.bookId()));

        if (book.isArchived() || !book.isShareable()) {
            throw new OperationNotPermittedException("You cannot give a feedback for an archived or not a shareable book");
        }

        User user = ((User) connectedUser.getPrincipal());

        if (!Objects.equals(book.getOwner().getId(), user.getId())) {
            throw new OperationNotPermittedException("You cannot give a feedback to your own book");
        }

        Feedback feedback = feedbackMapper.toFeedback(feedbackRequest);

        return feedbackRepository.save(feedback).getId();
    }

}
