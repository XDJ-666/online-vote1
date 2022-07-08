package com.cg.service;

import com.cg.entity.Battle;
import com.cg.entity.BattleTall;
import com.cg.entity.Player;

import java.util.List;

public interface BattleService {
    /**
     * 添加比赛信息
     * @param battle
     * @return
     */
    int insertBattleInfo(Battle battle);

    /**
     * 获取比赛信息
     * @return
     */
    List<BattleTall> getAllBattleInfo();
    /**
     * 修改通道状态
     * @param battle
     * @return
     */
    Integer updateStatus(Battle battle);

}
