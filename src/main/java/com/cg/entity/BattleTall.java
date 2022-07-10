package com.cg.entity;

import lombok.Data;

@Data
public class BattleTall {

    private int playerId;
    private int battleId;
    private String playerNameA;
    private String playerNameB;
    private String songA;
    private String songB;
    private int playerA;
    private int playerB;
    private float scoreA;
    private float scoreB;
    private float totalA;
    private float totalB;
    private int judgeId;
    private int pollA;
    private int pollB;
    private int status;
    private int winner;
    private String type;
}
