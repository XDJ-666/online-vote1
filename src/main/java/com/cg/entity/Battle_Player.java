package com.cg.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
@Component
@Data
public class Battle_Player {
    private int playerId;
    private int battleId;
    private String phone;
    private String playerName;
    private String image;

}
