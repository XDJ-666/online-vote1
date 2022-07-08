package com.cg.entity;

import lombok.Data;

@Data
public class Battle {

  private int battleId;
  private String songA;
  private String songB;
  private int playerA;
  private int playerB;
  private double scoreA;
  private double scoreB;
  private double totalA;
  private double totalB;
  private int judgeId;
  private int pollA;
  private int pollB;
  private int status;
  private int winner;


}
