package com.example.demo.Student;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
// or we can use @Service instead it.
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    public static void addNewStudent(Student student) {
        System.out.println(student);
    }
}
