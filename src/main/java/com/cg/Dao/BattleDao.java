package com.cg.Dao;

import com.cg.entity.Battle;
import com.cg.entity.BattleTall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BattleDao {
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
