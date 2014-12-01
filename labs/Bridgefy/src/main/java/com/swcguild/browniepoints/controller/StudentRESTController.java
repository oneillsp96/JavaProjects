package com.swcguild.browniepoints.controller;

import com.swcguild.browniepoints.dao.StudentDao;
import com.swcguild.browniepoints.model.Student;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/rest")
public class StudentRESTController {

    private StudentDao dao;

    @Inject
    public StudentRESTController(StudentDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/addPoint/{id}", method = RequestMethod.PUT)

    @ResponseBody
    public int addPoint(@PathVariable("id") int id) {
        Student student = dao.getStudentById(id);

        int p = (student.getPoints() + 1);

        student.setPoints(p);
        dao.updateStudent(student);  

       
        return student.getPoints();
    }
    
    
  

    @RequestMapping(value = "/subtractPoint/{id}", method = RequestMethod.PUT)

    @ResponseBody
    public int subtractPoint(@PathVariable("id") int id) {
        Student student = dao.getStudentById(id);

        int p = (student.getPoints() - 1);

        student.setPoints(p);
        dao.updateStudent(student); 

//        dao.getStudentById(id);
        return student.getPoints();
    }

}
//get student by id update student, send back new number
