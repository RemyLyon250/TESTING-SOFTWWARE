package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.BookServiceInterface;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = Application.class)
public class BookTests {

    @Autowired
    private BookServiceInterface bookServiceInterface;

    @Test
    @BeforeEach
    public void BookSaveTest(){
        Book book = new Book();
        book.setTitle("TestCases");
        book.setAuthorFirstname("kalisa");
        book.setAuthorLastname("kelly");
        book.setAuthorEmail("kelly@gmail.com");

        Book booksave =bookServiceInterface.savebook(book);

        assertNotNull(booksave);


    }
    @Test
    public void testFindAll(){
        List<Book> tickets = bookServiceInterface.findalltickets();
        assertEquals(13,tickets.size());
    }


    @BeforeAll
    @Test
    public void findbyid(){
        Book book = bookServiceInterface.findBookById(9);
        assertEquals("TestCases",book.getTitle());


    }

    @Test
    public void testupdate(){
        Book book = bookServiceInterface.updateBook(10,"TestCases2");
        assertEquals("TestCases2",book.getTitle());
    }

    @Test
    @AfterAll
    public void testdelete(){
       boolean deleteBook =bookServiceInterface.deleteBook(11);
       Book book = bookServiceInterface.findBookById(11);
       assertNull(book);
       assertTrue(deleteBook);
    }


}
