package com.simplify.persuasiblecrm;

import com.simplify.model.entity.Clue;
import com.simplify.service.impl.ClueServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClueTest {
    @Autowired
    private ClueServiceImpl clueService;
    @Test
    public void show(){
        List<Clue> clueList = clueService.getAllClue();
        for (Clue clue: clueList
             ) {
            System.out.println(clue);
        }
    }
}
