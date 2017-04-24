package com.tryspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    @RequestMapping(value = "/indexthis" )
    @ResponseBody
    public String homePage() {
        return "home";
    }
}