package com.hhy.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController

public class HomeController {

    @PostMapping("/ip")
    public ResponseEntity<String> ip(HttpServletRequest request){
        return ResponseEntity.ok("dd"+request.getRemoteAddr());
    }


    @GetMapping("/")
    public String home(){
        System.out.println("말차밀크티");
        return "home";
    }
}
