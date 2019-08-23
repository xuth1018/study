package com.example.demo.controller;

import com.example.demo.entity.Info;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InfoController {
    @PostMapping("/login")
    public String Login(@RequestBody Info info){

        return "success";
    }

    @PostMapping("/register")
    public String Register(@RequestBody Info info){

        return "success";
    }

}
