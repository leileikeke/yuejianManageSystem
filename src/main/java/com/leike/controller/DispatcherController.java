package com.leike.controller;

import com.leike.pojo.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 页面控制器
 * @description:
 * @author: leike
 * @date: 2019-08-04 16:31
 */
@Controller
@RequestMapping("/")
public class DispatcherController {

    @RequestMapping("/")
    public String index(HttpSession session, Model model) {

        Admin admin = (Admin) session.getAttribute("SESSION_ADMIN");

        if (admin.getRole().equals("systemAdmin")){
            model.addAttribute("systemAdmin",admin);
            return "index_system";
        }else if (admin.getRole().equals("clubAdmin")){
            model.addAttribute("clubAdmin",admin);
            return "index_club";
        }
        return "redirect:/error/error.html";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String jumpindex() {
        return "redirect:/index.jsp";
    }

//    @RequestMapping(path = "/info" ,produces = "text/plain;charset=UTF-8")
//    public ModelAndView info(HttpSession session) {
//
//        ModelAndView modelAndView = new ModelAndView("redirect:/views/set/user/info.html");
//        Admin admin = (Admin) session.getAttribute("SESSION_ADMIN");
//        modelAndView.addObject("id",admin.getId());
//        return modelAndView;
//    }


}
