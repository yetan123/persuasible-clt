package com.simplify.controller;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import com.simplify.utils.SnowFlake;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "clue")
@CrossOrigin
public class ClueController {
    @Resource
    ClueService clueService;
    @GetMapping(value = "list")
    public  List<ClueVO> getAllClue(){
        List<ClueVO> clueList = clueService.getAllClue();
        for (ClueVO clue: clueList
        ) {
            System.out.println(clue);
        }
        System.out.println("获取所有线索跳转成功");
        return clueService.getAllClue();
    }

    @GetMapping(value = "getAllSourceAndState")
    public SourceAndStateVO getAllSourceAndState(){
        System.out.println("获取来源与状态方法跳转成功");
        return clueService.getSourceAndStateVO();
    }

    @PostMapping(value = "addClue")
    public int addClue(@RequestBody Clue clue) {
        clue.setId(new SnowFlake(0, 0).nextId());
        System.out.println("添加方法跳转成功");
//        clueService.addClue(clue);
        return clueService.addClue(clue);
    }

    @GetMapping(value = "deleteClue")
    public int deleteClue( String id){
        System.out.println("删除方法跳转成功");
        return clueService.deleteClue(id);
    }
}
