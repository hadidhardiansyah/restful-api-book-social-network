package com.hadid.book_network.repository;

import com.hadid.book_network.entity.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface IBookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    @Query("""
            SELECT book
            FROM Book book
            WHERE book.archived = false
            AND book.shareable = true 
            AND book.owner.id != :userId
            """)
    Page<Book> findAllDisplayableBooks(Pageable pageable, Long userId);

}
