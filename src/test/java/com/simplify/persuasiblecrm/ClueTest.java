package com.simplify.persuasiblecrm;

import com.simplify.mapper.ClueMapper;
import com.simplify.mapper.ClueTaskMapper;
import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.entity.ClueTask;
import com.simplify.model.vo.ClueAndTaskVO;
import com.simplify.model.vo.ClueTaskDVO;
import com.simplify.model.vo.ClueTaskVO;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ClueTest {
    @Autowired
    private ClueService clueService;
    @Autowired
    private ClueMapper clueMapper;
    @Autowired
    ClueTaskMapper clueTaskMapper;
    @Test
    public void show(){
        Map map = new HashMap<>();
        map.put("userId", 1);
        List<ClueTaskVO> clueTaskVOS = clueTaskMapper.listClueTaskAndClueAndUser(map);
        for (ClueTaskVO clueTask : clueTaskVOS) {
            System.out.println(clueTask);
        }
        System.out.println();
    }
    @Test
    public void getClue(){
//        List<Clue> clueList = clueMapper.selectAll();
//        for (Clue clue: clueList
//        ) {
//            System.out.println(clue);
//        }
        // 根据id查询
    }

}
