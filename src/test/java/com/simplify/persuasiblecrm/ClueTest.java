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
<<<<<<< HEAD
    @Test
    public void show(){
        List<Clue> clueList = clueService.getAllClue();
        for (Clue clue: clueList
             ) {
            System.out.println(clue);
        }
    }
    @Test
    public void getClue(){
//        List<Clue> clueList = clueMapper.selectAll();
//        for (Clue clue: clueList
//        ) {
//            System.out.println(clue);
//        }
        // 根据id查询
        List<Clue> clueList = clueService.getAllClue();
        for (Clue clue: clueList
        ) {
            System.out.println(clue);
        }
    }
=======

>>>>>>> 7fd7e22b035ebeec6752b86f94a201aa47e28caf

}
