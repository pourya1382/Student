package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Hamidreza = new Student(
                    "Hamidrez",
                    "Hrk1380@gmail.com",
                    LocalDate.of(2002, Month.DECEMBER, 8)

            );
            Student Arshia = new Student(
                    "Arshia",
                    "Arshia1380@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 22)

            );
            repository.saveAll(List.of(Arshia, Hamidreza));
        };
    }
}
