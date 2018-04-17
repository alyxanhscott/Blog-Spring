package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
//    below method is a variation of the above
    @RequestMapping(path = "/lights", method = RequestMethod.GET)
    @ResponseBody
    public String lights() {
        return "Lights on";
    }

    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String sayHello2(@PathVariable String firstName, @PathVariable String lastName) {
            return "Hola, " + firstName + " " + lastName;
        }
}
