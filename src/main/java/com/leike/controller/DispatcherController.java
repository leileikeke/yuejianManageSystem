package com.leike.controller;

import com.leike.pojo.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
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
}
