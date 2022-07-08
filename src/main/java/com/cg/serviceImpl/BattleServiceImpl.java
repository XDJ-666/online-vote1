package com.cg.serviceImpl;

import com.cg.Dao.BattleDao;
import com.cg.Dao.UserDao;
import com.cg.entity.Battle;
import com.cg.entity.BattleTall;
import com.cg.entity.Player;
import com.cg.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BattleServiceImpl implements BattleService {
    @Autowired
    private BattleDao battleDao;
    @Autowired
    private UserDao userDao;
    @Override
    public int insertBattleInfo(Battle battle) {
       int flag = battleDao.insertBattleInfo(battle);
        return flag;
    }

    @Override
    public List<BattleTall> getAllBattleInfo() {
        List<BattleTall> battleList = battleDao.getAllBattleInfo();//对战表信息
        for (BattleTall battle: battleList) {
            Player playerA = userDao.getPlayerById(battle.getPlayerA());
            battle.setPlayerNameA(playerA.getPlayerName());
            Player playerB = userDao.getPlayerById(battle.getPlayerB());
            battle.setPlayerNameB(playerB.getPlayerName());
        }
        return battleList;
    }

    @Override
    public Integer updateStatus(Battle battle) {
        Integer flag = 1;
        List<BattleTall> list = battleDao.getAllBattleInfo();
        for (BattleTall ba : list) {
           if(ba.getStatus()==0){
               flag = 0;
           }
        }
        return flag;
    }

}
