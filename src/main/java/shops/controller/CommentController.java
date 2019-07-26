package shops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import shops.model.Comment;
import shops.reposytory.CommentReposytory;

@Controller
public class CommentController {

    @Autowired
    private CommentReposytory commentReposytory;

    @PostMapping("/comments")
    public String create(@ModelAttribute Comment comment){
        commentReposytory.save(comment);
        return "comment_added";
    }

    @GetMapping("/comments")
    public String show(ModelMap map){
        map.put("comment", commentReposytory.toString());
        return "show";
    }

}
