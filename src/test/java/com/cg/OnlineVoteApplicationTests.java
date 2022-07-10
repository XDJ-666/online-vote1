package com.cg;

import com.cg.serviceImpl.BattleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineVoteApplicationTests {
    @Autowired
    private BattleServiceImpl service;
    @Test
    void contextLoads() {
       service.getGamePlayerInfo();
    }

}
