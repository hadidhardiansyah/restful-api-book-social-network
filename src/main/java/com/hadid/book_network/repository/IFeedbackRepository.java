package com.hadid.book_network.repository;

import com.hadid.book_network.entity.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
}
