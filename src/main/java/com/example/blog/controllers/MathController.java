package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public int add(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }
    @GetMapping("/subtract/{a}/from/{b}")
    @ResponseBody
    public int subtract(@PathVariable int a, @PathVariable int b) {
        return b - a;
    }
    @GetMapping("/multiply/{c}/and/{d}")
    @ResponseBody
    public int multiply(@PathVariable int c, @PathVariable int d) {
        return c * d;
    }
    @GetMapping("/divide/{m}/by/{n}")
    @ResponseBody
    public String divide(@PathVariable int m, @PathVariable int n) {
        if ( n == 0) {
            return "Error";
        }
        return String.valueOf(m / n);
    }
}
