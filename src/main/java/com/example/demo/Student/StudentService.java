package com.example.demo.Student;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
// or we can use @Service instead it.
public class StudentService {
    private static StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByID(student.getId());
        if (studentOptional.isPresent()) {
            System.out.println("email taken!");
        }
        return studentRepository.save(student);
    }


    public void deleteStudentById(Long studentId) {
        boolean answer = studentRepository.existsById(studentId);
        if (!answer) {
            throw new IllegalStateException("this id does not exist!");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public Student updateStudentById(
            Long studentId,
            String name,
            String email
    ) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist!"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
        return studentRepository.save(student);
    }
}
