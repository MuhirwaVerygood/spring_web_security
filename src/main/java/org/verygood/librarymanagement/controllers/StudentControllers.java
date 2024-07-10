package org.verygood.librarymanagement.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.verygood.librarymanagement.models.Student;
import org.verygood.librarymanagement.services.StudentServices;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@RequiredArgsConstructor
@Tag(name="Student")
public class StudentControllers {
    private final StudentServices studentServices;
    @GetMapping
    public List<Student> getStudents(){
        return studentServices.getStudents();
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        return studentServices.addStudent();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
        return studentServices.updateStudent(id, student);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id){
        return studentServices.deleteStudent(id);

    }

}
