package com.cg.controller;

import com.cg.Dao.BattleDao;
import com.cg.Dao.UserDao;
import com.cg.entity.Battle;
import com.cg.serviceImpl.BattleServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BattleController {
    @Autowired
    private BattleServiceImpl service;
    @Autowired
    private BattleDao battleDao;
    /**
     * 添加比赛信息
     * @param playerA
     * @param playerB
     * @param judgeId
     * @param model
     * @param songA
     * @param songB
     * @return
     */
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
    @GetMapping("/battle/updateStatus/{flag}/{Id}")
    public String updateStatus(@PathVariable String flag, @PathVariable String Id){
        int battleId =Integer.parseInt(Id) ;
        Battle battle = new Battle();
        battle.setBattleId(battleId);
        if("0".equals(flag)){
            int status = 0;
            battle.setStatus(status);
           int tag = service.updateStatus(battle);
           if(tag==0){

           }else{
               battleDao.updateStatus(battle);
           }
        }else if("1".equals(flag)){
            int status = 1;
            battle.setStatus(status);
            battleDao.updateStatus(battle);
        }else if("2".equals(flag)){
            int status = 2;
            battle.setStatus(status);
//            int tag = service.updateStatus(battle);
            battleDao.updateStatus(battle);
        }
        return"main/manageVote";
    }
}
