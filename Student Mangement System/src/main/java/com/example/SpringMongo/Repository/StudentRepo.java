package com.example.SpringMongo.Repository;

import com.example.SpringMongo.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {

}
