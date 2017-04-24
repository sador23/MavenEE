package com.tryspring;


import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.misc.LoginAuthenticate;
import com.misc.Database;

import javax.xml.crypto.Data;
import java.sql.SQLException;

@Controller
public class LoginController {
    /* IF we want to send in the text with return, use ResponseBody
    @RequestMapping(value = "/login")
    @ResponseBody
    public String hello(){
        return "Hello!";
    }*/
    @Autowired
    private LoginAuthenticate auth;

    private Database data;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login_page(){
        return "login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String get_user_name(@RequestParam String name, ModelMap model, @RequestParam String password) throws SQLException {
        data=new Database();
        if(!data.get_users(name,password)){
            model.put("error","INVALID DATA, TRY AGAIN");
            return "login";
        }
        model.put("name",name);
        model.put("password",password);
        return "index";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register_page(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String save_data(@RequestParam String name, @RequestParam String password, ModelMap model) throws SQLException {
        data=new Database();
        data.Insert_Table(name,password);
        return "login";
    }


}
