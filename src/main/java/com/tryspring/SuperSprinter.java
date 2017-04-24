package com.tryspring;

import com.misc.StoriesData;
import com.misc.Story;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class SuperSprinter {

    private StoriesData data;

    @RequestMapping(value="/story", method = RequestMethod.GET)
    public String get_story_page(ModelMap model){
        model.put("welcome","Add new story");
        model.put("submit","Create");
        model.put("action","/story");
        return "story";
    }

    @RequestMapping(value = "/story", method = RequestMethod.POST)
    public String save_story(@RequestParam String title, @RequestParam String story, @RequestParam String criteria, @RequestParam String status, @RequestParam int value,@RequestParam float estimation, ModelMap model) throws SQLException {
        data=new StoriesData();
        data.add_story(title,story,criteria,status,value,estimation);
        Story[] result =data.list_story();
        model.put("story_list",result);
        model.put("popup","Successfully created a new story!");
        return "list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String get_list_page(ModelMap model, @RequestParam(required = false,defaultValue = "0") int id) throws SQLException {
        data=new StoriesData();
        if(!Integer.toString(id).equalsIgnoreCase("0")){
            data.delete_row(id);
        }
        System.out.print(Integer.toString(id));
        Story [] result=data.list_story();
        model.put("story_list",result);
        return "list";
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.GET)
    public String delete_item(){
        return "list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit_page(ModelMap model, @RequestParam(required = false,defaultValue = "0") int id) throws SQLException {
        data=new StoriesData();
        Story result;
        result=data.get_story(id);
        model.put("story",result);
        model.put("welcome","Edit Story");
        model.put("submit","Edit");
        model.put("action","/update?id=" + Integer.toString(id));
        return "story";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update_page(@RequestParam String id,@RequestParam String title, @RequestParam String story, @RequestParam String criteria, @RequestParam String status, @RequestParam int value,@RequestParam float estimation, ModelMap model) throws SQLException {
        data=new StoriesData();
        data.update_story(Integer.parseInt(id),title,story,criteria,status,value,estimation);
        Story [] result=data.list_story();
        model.put("story_list",result);
        return "list";
    }

    @RequestMapping(value="/todo",method = RequestMethod.GET)
    public String todo_page() {
        return "todo";
    }

}
