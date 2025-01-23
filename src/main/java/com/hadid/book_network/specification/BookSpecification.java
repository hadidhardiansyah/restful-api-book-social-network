package com.hadid.book_network.specification;

import com.hadid.book_network.entity.book.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> withOwner(Long ownerId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId));
    }

}
