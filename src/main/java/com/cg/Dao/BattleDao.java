package com.cg.Dao;

import com.cg.entity.Battle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BattleDao {
    /**
     * 添加比赛信息
     * @param battle
     * @return
     */
    int insertBattleInfo(Battle battle);
}
