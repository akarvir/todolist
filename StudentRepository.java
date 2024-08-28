package com.students.Studentloginpage;
import org.springframework.data.repository.CrudRepository;

 
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByNetid(String netid);
    Student findByName(String name);
    boolean existsByName(String name);
    boolean existsByNetid(String netid);
}   