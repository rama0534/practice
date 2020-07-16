package com.practice.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//public class HelloController extends AbstractController {
//    @Override
//    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse
//    httpServletResponse) throws Exception {
//
//        ModelAndView modelAndView = new ModelAndView("/HelloPage");
//        modelAndView.addObject("WelcomeMessage","Hi User, Welcome to the first Spring application" );
//        return modelAndView;
//    }
//}
@Controller
@RequestMapping("/greet")
public class HelloController {

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {

        ModelAndView model = new ModelAndView("/HelloPage");
        //    model.addObject("HelloWorld");
        model.addObject("msg", "Hello World");

        return model;
    }

    @RequestMapping("/hi")
    public ModelAndView hiWorld() {

        ModelAndView model = new ModelAndView("/HelloPage");

        model.addObject("msg", "Hi World");

        return model;
    }

}
