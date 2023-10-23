package com.ayaancode.cruddemo.dao;

import java.util.List;
import com.ayaancode.cruddemo.entity.Student;

public interface StudentDAO {
    
    void save(Student theStudent);

    // done for retrieving the id from the database
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
