package com.example.SpringMongo.Controller;

import com.example.SpringMongo.Model.Student;
import com.example.SpringMongo.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Student students) {

        studentServices.saveorUpdate(students);
        return students.getid();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Student> getStudents() {
        return studentServices.listAll();
    }

    // @GetMapping(value = "/{studentId}")
    // private Student getStudentById(@PathVariable String studentId)
    // {
    // return studentServices.getStudentById(studentId);
    // }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable String id) {
        Student student = studentServices.getById(id);

        if (student != null) {
            // Student with the given ID exists, so return it.
            return ResponseEntity.ok(student);
        } else {
            // Student with the given ID is not available, return a custom message.
            String message = "Student with ID " + id + " is not available.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    // @GetMapping("/getByName/{name}")
    // public ResponseEntity<String> getStudentByName(@PathVariable String name) {
    // Student student = studentServices.getStudentByName(name);
    // if (student != null) {
    // return ResponseEntity.ok("Student found: " + student.getName());
    // } else {
    // return ResponseEntity.notFound().body("Student with name " + name + " not
    // found");
    // }
    // }

    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name = "id") String _id) {
        student.setid(_id);
        studentServices.saveorUpdate(student);
        return student;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deleteStudent(@PathVariable("id") String _id) {
        studentServices.deleteStudent(_id);
    }

    @RequestMapping(value = "/search/{id}")
    private Student getStudents(@PathVariable(name = "id") String studentid) {
        return studentServices.getStudentById(studentid);
    }

}
