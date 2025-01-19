package com.hadid.book_network.repository;

import com.hadid.book_network.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {

}
