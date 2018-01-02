package com.aws.codestar.projecttemplates.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StartController {
    @RequestMapping(method = RequestMethod.GET)
    public String start(@PathVariable String id) {
        return "Hello from the StartController having the empty context path!";
    }
}