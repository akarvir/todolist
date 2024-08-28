package com.students.Studentloginpage;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List; 
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentservice;


    @GetMapping("/login")
    public String backtologin() {
        return "login.html";
    }

    @PostMapping("/login") //thymeleaf placeholder called tasks. 
    public String login(@RequestParam("netid") String netid, @RequestParam("password") String password, Model model) {

        boolean is_student = studentservice.has_an_account(netid);


        if(is_student) {

            Student student = studentservice.findiwithonesnetid(netid);
            model.addAttribute("user", student.getName());
            model.addAttribute("tasks",student.getTasks());
            return "welcome"; 


        }
        model.addAttribute("accountstatus", "You do not have a student account. Please create one!");
        return "register";


    }

    @PostMapping("/taskcompleted")
    public String complete_task(@RequestParam("further") String netid, @RequestParam("deletebutton") String task, Model model) {

        Student student = studentservice.findiwithonesnetid(netid);
        List<String> student_tasks = student.getTasks();
        student_tasks.remove(task);
        student.setTasks(student_tasks);
        studentservice.update(student);
        model.addAttribute("tasks", student.getTasks());
        model.addAttribute("user", netid);
        return "welcome";
        

        


    }

    @PostMapping("/addtask")
    public String add_task(@RequestParam("taskname") String task, @RequestParam("fname") String netid,  Model model) {

        Student student = studentservice.findiwithonesnetid(netid);
        List<String> student_tasks = student.getTasks();
        student_tasks.add(task);
        student.setTasks(student_tasks);
        student.setNetid(netid);
        studentservice.update(student);
        model.addAttribute("tasks",student.getTasks());
        model.addAttribute("user",netid);
        return "welcome";

    }

    @PostMapping("/trial")
    public String testing(@RequestParam("trial") String netid, Model model) {

        Student student = studentservice.findiwithonesnetid(netid);
        model.addAttribute("temp",student.getName()); 
        return "welcome";


    }


    @PostMapping("/createaccount")
    public String createaccount(@RequestParam String netid, @RequestParam String password, @RequestParam String name) {
        
        Student student = new Student();
        student.setName(name);
        student.setNetid(netid);
        student.setPassword(password);
        studentservice.add_to_database(student);
        return "login";

    }








}