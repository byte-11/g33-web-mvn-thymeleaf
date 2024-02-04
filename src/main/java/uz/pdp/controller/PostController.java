package uz.pdp.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Post;
import uz.pdp.repo.PostRepo;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepo postRepo;

    @GetMapping
//    localhost:8080/posts?id=2
    public ModelAndView postDetails(ModelAndView modelAndView, @RequestParam("id") String id) {
        Post post = postRepo.getById(id);
        modelAndView.addObject("post", post);
        modelAndView.setViewName("object_params");
        return modelAndView;
    }

    @GetMapping("/{id}")
//    localhost:8080/posts/4
    public ModelAndView postDetailsWithPathVariable(ModelAndView modelAndView, @PathVariable("id") String id) {
        Post post = postRepo.getById(id);
        modelAndView.addObject("post", post);
        modelAndView.setViewName("object_params");
        return modelAndView;
    }

}
