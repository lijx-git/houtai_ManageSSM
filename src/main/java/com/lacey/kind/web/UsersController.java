package com.lacey.kind.web;

import com.lacey.kind.entity.Users;
import com.lacey.kind.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/25.
 */
@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String login(String username, String password,HttpServletRequest request){
        System.out.println(username+" "+password);
        Users user=usersService.login(username,password);
        if(user!=null)
        {

            request.getSession().setAttribute("user",user);
           request.setAttribute("username",user.getUsername());
            return "/users/Users_login_success";
        }
        return "/users/Users_login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request)
    {
       if( request.getSession().getAttribute("user")!=null)
       {
           request.getSession().removeAttribute("user");
           return "/index";
       }
       return "/users/Users_login";
    }

}
