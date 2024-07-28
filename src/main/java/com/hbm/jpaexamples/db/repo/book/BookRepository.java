package com.hbm.jpaexamples.db.repo.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hbm.jpaexamples.db.entities.books.Book;

// import jakarta.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long>{

    @Transactional(readOnly = true)
    @Query(value = "from Book b where b.author.id=:id")
    List<Book> fetchByAuthorId(@Param("id") long id);    
}
