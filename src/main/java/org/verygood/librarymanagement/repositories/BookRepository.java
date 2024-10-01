package org.verygood.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.verygood.librarymanagement.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
    List<Book> findBookByIsBorrowedAndIsReturnedNot(Boolean isBorrowed, Boolean isReturned);
}


