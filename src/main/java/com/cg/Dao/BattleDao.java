package com.cg.Dao;

import com.cg.entity.Battle;
import com.cg.entity.BattleTall;
import com.cg.entity.Vote;
import org.apache.ibatis.annotations.Mapper;

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
    /**
     * 设置胜利方
     * @param battle
     * @return
     */
    int updateWinner(Battle battle);

    /**
     * 获取正在比赛的选手信息
     * @return
     */
    Battle getPlayerByStatus();

    /**
     * 评委评分
     * @param battle
     * @return
     */
    int updateScore(Battle battle);

    /**
     * 修改投票A
     * @param battle
     * @return
     */
    int updatePollA(Battle battle);

    /**
     * 修改投票B
     * @param battle
     * @return
     */
    int updatePollB(Battle battle);
    /**
     * 添加投票记录
     * @param vote
     * @return
     */
    int addPoll(Vote vote);

    /**
     * 查询是否投票
     * @param vote
     * @return
     */
    int isVote(Vote vote);
}
