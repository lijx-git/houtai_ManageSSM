package com.lacey.kind.web;

import com.lacey.kind.entity.Teachers;
import com.lacey.kind.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/teachers")
public class TeachersController {
    @Autowired
    private TeachersService teachersService;

    /***
     * 所有老师信息列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(HttpServletRequest request) {
        List<Teachers> teaList = teachersService.queryTaechers();
        request.setAttribute("teachersList", teaList);
        return "/WEB-INF/teachers/Teachers_query_success";
    }

    /***
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd()
    {
        return "/WEB-INF/teachers/Teachers_add";
    }

    /**
     * 添加教师
     * @param teachers
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Teachers teachers)
    {
        System.out.println("teachers="+teachers);
        teachersService.addTeachers(teachers);
        return "/WEB-INF/teachers/Teachers_add_success";
    }

    /**
     * 删除教师
     * @param tid
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam(value = "tid") Long tid,HttpServletRequest request)
    {
        teachersService.deleteTeachers(tid);
        List<Teachers> teaList = teachersService.queryTaechers();
        request.setAttribute("teachersList", teaList);
        return "/WEB-INF/teachers/Teachers_query_success";
    }

    /**
     * 跳转到查找页面
     * @return
     */
    @RequestMapping(value = "/toFind",method = RequestMethod.GET)
    public String toFind()
    {
        System.out.println("进入了Teachers的toFind");
        return "/WEB-INF/teachers/Teachers_find";
    }

    /**
     * 查询教师信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public String find(HttpServletRequest request)
    {
      String key= request.getParameter("key");
        String val=request.getParameter("val");
        System.out.println("key="+key+"val"+val);
        List<Teachers> TeaList=teachersService.findTeachers(key,val);
        request.setAttribute("teachers",TeaList);
        return "/WEB-INF/teachers/Teachers_find";

    }

    /**
     * 跳转到修改教师信息页面
     * @param tid
     * @param request
     * @return
     */
    @RequestMapping(value = "/toModify",method = RequestMethod.GET)
    public String toModify(@RequestParam(value = "tid") long tid,HttpServletRequest request)
    {
         Teachers teachers=teachersService.findTeaByTid(tid);
        System.out.println("teacher"+teachers);
        System.out.println("IDNumber"+teachers.getIDNumber());
         request.setAttribute("teacher",teachers);
        return "/WEB-INF/teachers/Teachers_modify";
    }
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public String modify(Teachers teachers)
    {
        System.out.println("teachers="+teachers);
        teachersService.modifyTeacher(teachers);
        return "/WEB-INF/teachers/Teachers_modify_success";
    }

}

