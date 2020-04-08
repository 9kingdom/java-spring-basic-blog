package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public String listPosts(Model model){

        List<Post> posts = postRepository.getAllPosts();
        model.addAttribute("posts", posts);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, Model model){
        model.addAttribute("post", postRepository.findById(id));
        return "post-details";
    }

}
