package com.cg.serviceImpl;

import com.cg.Dao.BattleDao;
import com.cg.entity.Battle;
import com.cg.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleServiceImpl implements BattleService {
    @Autowired
    private BattleDao battleDao;
    @Override
    public int insertBattleInfo(Battle battle) {
       int flag = battleDao.insertBattleInfo(battle);
        return flag;
    }
}
