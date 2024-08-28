package com.students.Studentloginpage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.util.List;
import java.util.ArrayList;




@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Student")
public class Student {


    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String netid;

    private String password;

    private List<String> tasks = new ArrayList<String>();

    
}
