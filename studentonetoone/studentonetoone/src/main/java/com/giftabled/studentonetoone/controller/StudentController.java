package com.giftabled.studentonetoone.controller;

import com.giftabled.studentonetoone.model.Student;
import com.giftabled.studentonetoone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {

        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
//        try {
//            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
//        } catch (Exception e) {
//            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            System.out.println();
//            return
//        }
    }

    @GetMapping("/student")
    public ResponseEntity<?> getAllStudents() {

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {

        Optional<Student> student = studentService.getStudentById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,
                                           @RequestBody Student student) {

        Student updated = studentService.updateStudent(id, student);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        boolean deleted = studentService.deleteStudent(id);

        if (deleted) {
            return ResponseEntity.ok("Deleted Student successfully");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Student with ID '" + id + "' not found.");
    }
}
