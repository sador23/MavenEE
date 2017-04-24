package com.tryspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sador on 01.03.17.
 */
@Controller
public class IndexPage {


    @RequestMapping(value = "/" )
    public String indexPage() {
        return "index";
    }

}
