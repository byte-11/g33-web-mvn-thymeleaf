package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Post;
import uz.pdp.repo.PostRepo;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostRepo postRepo;

    @GetMapping
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("username", "Alex");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/message-source")
    public String messageSource() {
        return "message_source";
    }

    @GetMapping("/object-param")
    public ModelAndView objectParams(ModelAndView modelAndView) {
        modelAndView.addObject(
                "post", Post.builder()
                        .id("1")
                        .title("Thymeleaf")
                        .context("Today we are learning thymeleaf usage with html")
                        .author("Alex")
                        .publishedTime(new Date()).build()
        );
        modelAndView.setViewName("object_params");
        return modelAndView;
    }

    @GetMapping("/links")
    public ModelAndView dynamicLinks(ModelAndView modelAndView){
        modelAndView.addObject("posts", postRepo.getPosts());
        modelAndView.setViewName("links");
        return modelAndView;
    }

    @GetMapping("/literals")
    public ModelAndView literals(ModelAndView modelAndView){
        modelAndView.addObject("username", "Bob");
        modelAndView.addObject("age", 25);
        modelAndView.addObject("gender", "Male");
        modelAndView.setViewName("literals");
        return modelAndView;
    }

    @GetMapping("/arithmetics")
    public String arithmetics(){
        return "arithmetics";
    }

    @GetMapping("/conditionals")
    public String conditionals(){
        return "conditionals";
    }

    @GetMapping("/no-operation-token")
    public ModelAndView noOperationToken(ModelAndView modelAndView){
        modelAndView.addObject("isOk", false);
        modelAndView.setViewName("no_operation_token");
        return modelAndView;
    }

    @GetMapping("/attributes")
    public ModelAndView attributes(ModelAndView modelAndView){
        modelAndView.addObject("buttons", List.of(
                "danger",
                "warning",
                "info",
                "success"
        ));
        modelAndView.setViewName("attributes");
        return modelAndView;
    }

    @GetMapping("/switch-condition")
    public String switchCondition(){
        return "switch_condition";
    }
}
