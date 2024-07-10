package org.verygood.librarymanagement.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.verygood.librarymanagement.models.Book;
import org.verygood.librarymanagement.models.Student;
import org.verygood.librarymanagement.repositories.BookRepository;
import org.verygood.librarymanagement.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksServices {
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        Optional<Book> bookNameExists = bookRepository.findByName(book.getName());
        if(bookNameExists.isPresent()){
            throw  new IllegalStateException("The book with that name already exists");
        }
        bookRepository.save(book);
        System.out.println("The book saved successfully");
    }

    public void deleteBook(Long id) {
        boolean bookExistsById = bookRepository.existsById(id);
        if(!bookExistsById) {
            throw  new IllegalStateException("The book with that id does not exist");
        }
        bookRepository.deleteById(id);
        System.out.println("The book deleted successfully");
    }
@Transactional
    public void updateBook(Long id, Book book) {
     Book bookExists = bookRepository.findById(id).orElseThrow(()-> new IllegalStateException("The book with that id does not exist"));
     if(!Objects.equals(book.getName() , bookExists.getName()) && !Objects.equals(book.getAuthor(), bookExists.getAuthor()) &&  !Objects.equals(book.getPublisher(), bookExists.getPublisher())  && !Objects.equals(book.getPublication_date(), bookExists.getPublication_date())) {
         bookExists.setName(book.getName());
         bookExists.setAuthor(book.getAuthor());
         bookExists.setPublisher(book.getPublisher());
         bookExists.setPublication_date(book.getPublication_date());
         System.out.println("The book updated successfully");
     }
    }

    public ResponseEntity<String> borrowBook(Integer bookId, Integer studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("Student with that id does not exist"));
        Book book = bookRepository.findById(Long.valueOf(bookId)).orElseThrow(()->new IllegalStateException("Book with that id not found"));
        if(!(book == null)){
            book.setIsBorrowed(true);
            book.setStudent(student);
            List<Book> borrowedBooks = new ArrayList<>();
            borrowedBooks.add(book);
            student.setBorrowedBooks(borrowedBooks);
            return ResponseEntity.ok("Book borrowed successfully");
        }else{
            throw new IllegalStateException("Book with that id not found");
        }

    }


    public List<Book> getBorrowedBooks() {
        return bookRepository.findBookByIsBorrowedAndIsReturnedNot(true, false);
    };


}
