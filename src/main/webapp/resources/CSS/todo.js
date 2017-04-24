/**
 * Created by sador on 17.03.17.
 */
$(document).ready(function () {
    var do_list=[];

    function story(name){
        this.name=name;
        this.todo_list=[]
        this.add_todo=function(text){
          this.todo_list.push(new todo(text))
        };

    };

    function todo(text){
        this.text=text;
    }

});