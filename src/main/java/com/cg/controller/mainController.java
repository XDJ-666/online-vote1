package com.cg.controller;

import com.cg.entity.*;
import com.cg.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class mainController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login/login";
    }
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register/register";
    }
    @GetMapping("/main/manager")
    public String toManager(){
        return"main/manager";
    }
    @GetMapping("/main/addPlayer")
    public String toAddPlayer(){
        return "main/addPlayer";
    }
    @GetMapping("/main/setBattle")
    public String toSetBattle(Model model){
        List<Player> list = userService.getAllPlayer();
        model.addAttribute("players",list);
        List<Judge> judges = userService.getAllJudge();
        model.addAttribute("judges",judges);
        return "main/settingBattle";
    }
    @GetMapping("/main/main")
    public String main(){
        return "main/main";
    }
    @GetMapping("/main/manageVote")
    public String manageVote(){
        return "main/manageVote";
    }
    @GetMapping("/main/toAddJudge")
    public String toAddJudge(){
        return "main/addJudge";
    }
    @PostMapping("/doRegister")
    public String Register(Audience audience, Model model){
       int flag = userService.selectAudienceByPhone(audience.getPhone());
       if(flag==0){
           userService.insertAudience(audience);
           return "login/login";
       }else {
           model.addAttribute("flag",flag);
           return "register/register";
       }
    }
    @PostMapping("/doLogin")
    public String Login(String userName,String password,String tag,Model model){
        int flag=0;
        if("0".equals(tag)){
            //观众
            Audience audience = new Audience();
            audience.setPhone(userName);
            audience.setPassword(password);
           Audience result = userService.selectAudience(audience);
           if(result!=null){
               return "main/vote";
           }else{
               flag = 1;
               model.addAttribute("flag",flag);
               return "login/login";
           }
        }else if("1".equals(tag)){
            //管理员
            Admin admin = new Admin();
            admin.setAccount(userName);
            admin.setPassword(password);
            Admin result = userService.selectAdmin(admin);
            if(result!=null){
                int scale = result.getScale();
                if(scale==0){
                    return "main/manager";
                }else{
                    return "main/manageSys";
                }
            }else{
                flag = 1;
                model.addAttribute("flag",flag);
                return "login/login";
            }
        } else if ("2".equals(tag)) {
            Judge judge = new Judge();
            judge.setAccount(userName);
            judge.setPassword(password);
            Judge result = userService.selectJudge(judge);
            if(result!=null){
                return "main/judge";
            }else{
                flag = 1;
                model.addAttribute("flag",flag);
                return "login/login";
            }
        }
        return "login/login";
    }
}
