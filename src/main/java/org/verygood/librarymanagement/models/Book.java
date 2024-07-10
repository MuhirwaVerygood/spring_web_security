
package org.verygood.librarymanagement.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")

public class Book{
    @Id
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq" )
    private Long id;
    private Boolean isBorrowed;
    private Boolean isReturned;
    private String name;
    private String author;
    private String publisher;
    private String  subject;
    private LocalDateTime publication_date;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}