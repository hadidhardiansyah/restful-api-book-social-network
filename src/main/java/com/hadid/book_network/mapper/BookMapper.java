package com.hadid.book_network.mapper;

import com.hadid.book_network.dto.request.BookRequest;
import com.hadid.book_network.entity.book.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .synopsis(request.synopsis())
                .archived(false)
                .shareable(request.shareable())
                .build();
    }

}
