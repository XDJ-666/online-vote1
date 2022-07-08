package com.cg.service;

import com.cg.entity.Battle;

public interface BattleService {
    /**
     * 添加比赛信息
     * @param battle
     * @return
     */
    int insertBattleInfo(Battle battle);
}
