package com.hbm.jpaexamples.book;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hbm.jpaexamples.db.entities.books.Author;
import com.hbm.jpaexamples.db.entities.books.Book;
import com.hbm.jpaexamples.db.repo.book.AuthorRepository;
import com.hbm.jpaexamples.db.repo.book.BookRepository;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
public class BookRepoTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void saveAndUpdateBooks() {
        Author author = new Author();
        author.setName("test");
        author =  authorRepository.save(author);
        Book book1 = new Book();
        book1.setBookName("testbook1");
        book1.setAuthor(author);
        Book book2 = new Book();
        book2.setBookName("testbook2");
        book2.setAuthor(author);

        List<Book> savedBooks = bookRepository.saveAll(List.of(book1, book2));
        log.info("Saved book Ids {}", savedBooks.stream().map(Book::getId).collect(Collectors.toList()));  
        log.info("saved Author id {}", author.getId());

        List<Book> fetchByAuthorId = bookRepository.fetchByAuthorId(1L);
        log.info("books by author id", fetchByAuthorId);
    }
}
