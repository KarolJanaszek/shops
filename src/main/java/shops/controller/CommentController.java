package shops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return "redirect:/";
    }

}
