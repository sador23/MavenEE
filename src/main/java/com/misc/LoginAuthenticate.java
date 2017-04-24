package com.misc;

import org.springframework.stereotype.Service;

/**
 * Created by sador on 01.03.17.
 */

@Service
public class LoginAuthenticate {
    public boolean is_input_valid(String name, String password){
        System.out.println(password);
        return name.equalsIgnoreCase("bela") && password.equalsIgnoreCase("123");
    }
}
