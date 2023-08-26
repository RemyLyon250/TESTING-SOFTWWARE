package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;


public interface BookServiceInterface {
Book savebook(Book book);

List<Book> findalltickets();

Book findBookById(Integer book_id);

boolean deleteBook (int book_id);

Book updateBook (int book_id,String title );






}
