package com.example.SpringMongo.Service;

import com.example.SpringMongo.Model.Student;
import com.example.SpringMongo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServices {

    @Autowired
    private StudentRepo studentRepo;

    public void saveorUpdate(Student students) {
    studentRepo.save(students);
    }

    public Iterable<Student> listAll() {

        return this.studentRepo.findAll();
    }

    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(String studentid) {
        return studentRepo.findById(studentid).get();
    }

    public Student getById(String id) {
        return studentRepo.findById(id).orElse(null);
    }

//    public Student getStudentByName(String name) {
//        return studentRepo.findByName(name);
//    }
    }

