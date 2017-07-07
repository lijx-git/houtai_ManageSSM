package com.lacey.kind.web;

import com.lacey.kind.entity.Students;
import com.lacey.kind.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
@Controller
@RequestMapping(value = "/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(HttpServletRequest request) {
        List<Students> studentsList = studentsService.findAllStu();
        request.setAttribute("studentsList", studentsList);
        return "/WEB-INF/students/Students_query_success";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(@RequestParam("sid") long sid, HttpServletRequest request) {

        System.out.println("sid=" + sid);
        Students student = studentsService.findStuById(sid);
        System.out.println("birthday=" + student.getBirthday());
        request.setAttribute("student", student);
        return "/WEB-INF/students/Students_modify";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Students students, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("students=" + students.getGender());
        System.out.println("students=" + students.getBirthday());
        studentsService.deleteStuById(students.getSid());
        studentsService.addStudent(students);
        return "/WEB-INF/students/Students_modify_success";
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "/WEB-INF/students/Students_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStu(Students students) {
        studentsService.addStudent(students);
        return "/WEB-INF/students/Students_add_success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("sid") long sid, HttpServletRequest request) {
        studentsService.deleteStuById(sid);
        List<Students> studentsList = studentsService.findAllStu();
        request.setAttribute("studentsList", studentsList);
        return "/WEB-INF/students/Students_query_success";
    }

    @RequestMapping(value = "/find",method =RequestMethod.POST)
    public String find(HttpServletRequest request) {
      String key=request.getParameter("key");
      String val=request.getParameter("val");
      System.out.println("key="+key+"val="+val);
     List<Students> stuList=studentsService.findStu(key,val);
     System.out.println("stuList"+stuList);
     request.setAttribute("students",stuList);
     return "/WEB-INF/students/Students_find";
    }
    @RequestMapping(value = "/toFind",method = RequestMethod.GET)
    public String toFind()
    {
        System.out.println("进入了toFInd");
        return "/WEB-INF/students/Students_find";
    }
}
