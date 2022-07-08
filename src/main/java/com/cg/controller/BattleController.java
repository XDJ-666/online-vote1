package com.cg.controller;

import com.cg.entity.Battle;
import com.cg.serviceImpl.BattleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BattleController {
    @Autowired
    private BattleServiceImpl service;
    @PostMapping("/battle/addBattle")
    public String inserBattleInfo(String playerA,String playerB,String judgeId, Model model,String songA,String songB){
        int flag = 0;//标识
        Battle battle = new Battle();
        battle.setPlayerA(Integer.valueOf(playerA));
        battle.setPlayerB(Integer.valueOf(playerB));
        battle.setJudgeId(Integer.valueOf(judgeId));
        battle.setSongA(songA);
        battle.setSongB(songB);
        System.out.println(battle);
        if(battle.getPlayerA()== battle.getPlayerB()){
            flag = 1;
            model.addAttribute("flag",flag);
        }else{
            int result = service.insertBattleInfo(battle);
            model.addAttribute("flag",flag);
        }
        return"main/settingBattle";
    }
}
