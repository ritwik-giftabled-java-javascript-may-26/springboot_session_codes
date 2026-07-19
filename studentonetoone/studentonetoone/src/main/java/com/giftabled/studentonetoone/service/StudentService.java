package com.giftabled.studentonetoone.service;

import com.giftabled.studentonetoone.model.Student;
import com.giftabled.studentonetoone.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student student) {

        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {

            Student existing = optional.get();

            existing.setName(student.getName());
            existing.setStudentIDCard(student.getStudentIDCard());

            return studentRepository.save(existing);
        }

        return null;
    }

    public boolean deleteStudent(Long id) {

        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
