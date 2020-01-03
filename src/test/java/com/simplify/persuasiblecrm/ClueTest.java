package com.simplify.persuasiblecrm;

import com.simplify.mapper.ClueMapper;
import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueAndTaskVO;
import com.simplify.model.vo.ClueTaskDVO;
import com.simplify.model.vo.ClueTaskVO;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClueTest {
    @Autowired
    private ClueService clueService;
    @Autowired
    private ClueMapper clueMapper;
    @Test
    public void show(){
        List<ClueVO> clueList = clueService.getAllClue();
        for (ClueVO clue: clueList
             ) {
            System.out.println(clue);
        }
    }
    @Test
    public void getClue(){
        ClueTaskDVO c = new ClueTaskDVO();
        c.setTaskContent("12");
        c.setTaskStartTime("2019-1-1");
        c.setTaskFinishTime("2020-8-8");
        c.setClueId("410547641085067264");
        c.setId("31312");
        System.out.println(c);
    }
}
