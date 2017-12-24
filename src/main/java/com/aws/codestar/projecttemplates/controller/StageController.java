package com.aws.codestar.projecttemplates.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stage")
public class StageController {
    @RequestMapping(method = RequestMethod.GET)
    public String hello(@PathVariable String id) {
        return "Hello from the Stagecontroller!";
    }
}