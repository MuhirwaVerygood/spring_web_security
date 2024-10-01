package org.verygood.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.verygood.librarymanagement.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
