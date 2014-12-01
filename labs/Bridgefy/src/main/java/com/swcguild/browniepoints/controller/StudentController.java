package com.swcguild.browniepoints.controller;

import com.swcguild.browniepoints.dao.StudentDao;
import com.swcguild.browniepoints.model.Student;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private StudentDao dao;

    @Inject
    public StudentController(StudentDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayStudentRoster", method = RequestMethod.GET)
    public String displayStudentRoster(Model model) {
        List<Student> sList = dao.getAllStudents();
        model.addAttribute("studentList", sList);
        return "displayStudentRoster";

    }

    @RequestMapping(value = "/displayAddStudentForm", method = RequestMethod.GET)
    public String displayAddStudentForm(Model model) {
        return "addStudentForm";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(Model model, HttpServletRequest req, HttpServletResponse res) {

        String firstName = req.getParameter("studentFirstName");
        String lastName = req.getParameter("studentLastName");
        String points = req.getParameter("studentPoints");
        String side = req.getParameter("studentSide");

        try {
            Student s = new Student();
            s.setFirstName(firstName);
            s.setLastName(lastName);
            s.setPoints(Integer.parseInt(points));
            s.setSide(side);

            dao.addStudent(s);

            return "redirect: displayStudentRoster";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Please enter an integer in points");

            return "addStudentForm";
        }
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("studentId") int id) {
        dao.removeStudent(id);
        return "redirect:displayStudentRoster";

    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(HttpServletRequest req, HttpServletResponse res) {
        Student s = new Student();

        s.setStudentId(Integer.parseInt(req.getParameter("studentId")));
        s.setFirstName(req.getParameter("studentFirstName"));
        s.setLastName(req.getParameter("studentLastName"));
        s.setPoints(Integer.parseInt(req.getParameter("studentPoints")));
        s.setSide(req.getParameter("studentSide"));

        dao.updateStudent(s);
        return "redirect:displayStudentRoster";

    }

    @RequestMapping(value = "/displayEditStudentForm", method = RequestMethod.GET)
    public String displayEditStudentForm(@RequestParam("studentId") int id, Model model) {
        //model is so that view can display stuff in edit contact form
        Student s = dao.getStudentById(id);

        model.addAttribute("student", s);
        //forward to view 

        return "editStudentForm";

    }

//    //Non-Ajax implementation - repaints whole page when points are added
//    @RequestMapping(value = "/addPoint", method = RequestMethod.GET)
//    public String addPoint(@RequestParam("studentId") int id, Model model, HttpServletRequest req, HttpServletResponse res) {
//
//        Student s = new Student();
//        s.setStudentId(id);
//        int p = ((Integer.parseInt(req.getParameter("studentPoints"))) + 1);
//        s.setPoints(p);
//
//        s.setFirstName(req.getParameter("studentFirstName"));
//        s.setLastName(req.getParameter("studentLastName"));
//        s.setSide(req.getParameter("studentSide"));
//
//        dao.updateStudent(s);
//        return "redirect:displayStudentRoster";
//    }
//    
    //non-Ajax implememtation - repaints whole page when points are added
//
//    @RequestMapping(value = "/subtractPoint", method = RequestMethod.GET)
//    public String subtractPoint(@RequestParam("studentId") int id, Model model, HttpServletRequest req, HttpServletResponse res) {
//
//        Student s = new Student();
//        s.setStudentId(id);
//        int p = ((Integer.parseInt(req.getParameter("studentPoints"))) - 1);
//        s.setPoints(p);
//
//        s.setFirstName(req.getParameter("studentFirstName"));
//        s.setLastName(req.getParameter("studentLastName"));
//        s.setSide(req.getParameter("studentSide"));
//
//        dao.updateStudent(s);
//        return "redirect:displayStudentRoster";
//    }
}
