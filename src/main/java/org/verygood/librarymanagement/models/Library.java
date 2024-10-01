package org.verygood.librarymanagement.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Library {
    @Id
    @SequenceGenerator(name = "library_seq", sequenceName = "library_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_seq")
    private Integer id;
    @OneToMany(mappedBy = "library")
    private List<Book> availableBooks;
}
