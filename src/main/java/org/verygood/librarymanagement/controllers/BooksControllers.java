package org.verygood.librarymanagement.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.verygood.librarymanagement.models.Book;
import org.verygood.librarymanagement.services.BooksServices;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
@RequiredArgsConstructor
@Tag(name = "Books")
public class BooksControllers {
    private final BooksServices booksServices;

    @GetMapping
    public List<Book> getAllBooks(){

    return booksServices.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){

    booksServices.addBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long id){
    booksServices.deleteBook(id);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(@PathVariable("bookId") Long id, @RequestBody Book book){
    booksServices.updateBook(id, book);
    }

    @PostMapping("/borrow/{bookId}")
    public ResponseEntity<String> borrowBook(@PathVariable("bookId") Integer bookId, @RequestBody Integer studentId){
        return booksServices.borrowBook(bookId, studentId);
    }

    @GetMapping("/getBorrowed")
    public List<Book> getBorrowedBooks(){
        return booksServices.getBorrowedBooks();
    }





}
