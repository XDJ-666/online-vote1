package com.cg.controller;

import com.cg.entity.Judge;
import com.cg.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JudgeController {
    @Autowired
    private UserServiceImpl service;
    @PostMapping("/main/addJudge")
    public String addJudge(Judge judge){
        service.insertJudge(judge);
        return "main/addJudge";
    }
}
