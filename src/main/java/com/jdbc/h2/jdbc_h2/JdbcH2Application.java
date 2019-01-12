package com.jdbc.h2.jdbc_h2;

import com.jdbc.h2.jdbc_h2.student.Student;
import com.jdbc.h2.jdbc_h2.student.StudentJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcH2Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentJdbcRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcH2Application.class, args);
    }

    @Override
    public void run(String...args) throws Exception {
        logger.info("Student id 10001 -> {}", repository.findById(10001L));
        logger.info("Kowalski are -> {}", repository.findByName("Kowalski"));
        logger.info("Students who are on WIMIC -> {}", repository.findByDepartment("WIMIC"));

        Student student = new Student(10003L,"Krawczyk","WIMIP");
        //logger.info("Delete person from study -> {}", repository.deleteByName("Kowalski"));
        logger.info("Add number of students -> {}",repository.insert(student));
        student.setName("Wlazły");
        repository.update(student);

        logger.info("All students are -> {}", repository.findAll());
    }

}

