package com.students.Studentloginpage;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service 
public class StudentService{

    @Autowired
    private StudentRepository studentrepository;

    public boolean has_an_account(String netid) {
        return studentrepository.existsByNetid(netid);
    }

    public boolean isindatabase(String name) {
        return studentrepository.existsByName(name);
    }

    public Student findiwithonesnetid(String netid) {
        return studentrepository.findByNetid(netid);
    }

    public Student findwithonesname(String name) {
        return studentrepository.findByName(name);
    }

    public void add_to_database(Student student) {
        studentrepository.save(student);
    }

    public void update(Student student) {
        studentrepository.save(student);
    }


}
