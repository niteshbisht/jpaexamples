package com.hbm.jpaexamples.db.repo.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbm.jpaexamples.db.entities.books.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
}
