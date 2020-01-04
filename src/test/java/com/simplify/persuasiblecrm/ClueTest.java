package com.simplify.persuasiblecrm;

import com.simplify.mapper.ClueMapper;
import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
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

    }
}
