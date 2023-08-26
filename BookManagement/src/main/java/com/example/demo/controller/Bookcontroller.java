package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class Bookcontroller {

    @Autowired
    private BookServiceInterface bookServiceInterface;


    @PostMapping("/save")
    public ResponseEntity<Book> savebook(@RequestBody Book book){

        Book savebook = bookServiceInterface.savebook(book);

        return new ResponseEntity<>(savebook, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>>getAllbooks(){
        List<Book>books=bookServiceInterface.findalltickets();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
    @GetMapping("/{book_id}")
    public ResponseEntity<Book> getBookById(@PathVariable("book_id") Integer bookId) {
        Book book = bookServiceInterface.findBookById(bookId);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("book_id") int bookId) {
        boolean deleted = bookServiceInterface.deleteBook(bookId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{book_id}")
    public ResponseEntity<Book> updateBookTitle(
            @PathVariable("book_id") int bookId,
            @RequestBody String newTitle) {
        Book updatedBook = bookServiceInterface.updateBook(bookId, newTitle);
        if (updatedBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

}
