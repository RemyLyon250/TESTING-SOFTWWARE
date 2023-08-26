package com.example.demo.service;

import com.example.demo.dao.BookRepo;
import com.example.demo.model.Book;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface{

    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book savebook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> findalltickets() {
        return bookRepo.findAll();
    }

    @Override
    public Book findBookById(Integer book_id) {
        return bookRepo.findById(book_id).orElse(null);

    }

    @Override
    public boolean deleteBook(int book_id) {

        Book book = bookRepo.findById(book_id).orElse(null);
        if(book!=null){
            bookRepo.deleteById(book_id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Book updateBook(int book_id, String title) {
        Book book = bookRepo.findById(book_id).orElse(null);
        if (book!=null){
            book.setTitle(title);
            return bookRepo.save(book);

        }
        else {
            throw new ObjectNotFoundException(Book.class,String.valueOf(book_id)) ;
        }
    }
}
