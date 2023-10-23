package com.ayaancode.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ayaancode.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    // @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student thStudent) {
        entityManager.persist(thStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ",Student.class);

        //return Query Results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
     
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);

        //set query parameters  do
        theQuery.setParameter("theData",theLastName);

        //return query results
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class , id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowDeleted;
    }

    
}
