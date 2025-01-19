package com.hadid.book_network.service.implementation;

import com.hadid.book_network.dto.request.BookRequest;
import com.hadid.book_network.entity.book.Book;
import com.hadid.book_network.entity.user.User;
import com.hadid.book_network.mapper.BookMapper;
import com.hadid.book_network.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    private final IBookRepository bookRepository;

    public Long save (BookRequest request, Authentication connectedUser) {
        User user = ((User) connectedUser.getPrincipal());
        Book book = bookMapper.toBook(request);

        book.setOwner(user);

        return bookRepository.save(book).getId();
    }

}
