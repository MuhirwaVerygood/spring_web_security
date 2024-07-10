package org.verygood.librarymanagement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.verygood.librarymanagement.models.Student;
import org.verygood.librarymanagement.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServices {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<String> addStudent() {
        return ResponseEntity.ok("Student added successfully");

    }

    public ResponseEntity<String> updateStudent(Integer id, Student student) {
        return ResponseEntity.ok("Student updated successfully");
    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        return ResponseEntity.ok("Student deleted successfully");

    }
}
