package com.fullstack.FullStackProject.service;

import com.fullstack.FullStackProject.exception.UserNotFoundException;
import com.fullstack.FullStackProject.model.Book;
import com.fullstack.FullStackProject.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    public Book findBookById(Long id) {
        return (Book) bookRepo.findBookById(id).orElseThrow(() -> new UserNotFoundException("Book by id " + id + " was not found"));
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepo.deleteBookById(id);
    }


}
