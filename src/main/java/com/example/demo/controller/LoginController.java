package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private StudentRepository sr;

    @PostMapping(value = "/nsms/studentlogin")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            map.put("msg","用户名和密码不能为空");
            return "studentlogin";
        }else{
            Student student =sr.findByStudentId(username);
            if(student==null){
                map.put("msg","用户不存在");
                return "studentlogin";
            }
            if(student.getPassword().equals(password)) {
                return "redirect:/student";
            }else{
                map.put("msg","用户名或密码不正确");
                return "studentlogin";
            }
        }
        //return "student";
    }
}
