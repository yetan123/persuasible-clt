package com.simplify.controller;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import com.simplify.utils.SnowFlake;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "clue")
@CrossOrigin
public class ClueController {
    @Resource
    ClueService clueService;

    //获取全部线索
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

    //获取所有来源和状态
    @GetMapping(value = "getAllSourceAndState")
    public SourceAndStateVO getAllSourceAndState(){
        System.out.println("获取来源与状态方法跳转成功");
        return clueService.getSourceAndStateVO();
    }

    //添加线索
    @PostMapping(value = "addClue")
    public int addClue(@RequestBody Clue clue) {
        clue.setId(new SnowFlake(0, 0).nextId());
        System.out.println("添加方法跳转成功");
//        clueService.addClue(clue);
        return clueService.addClue(clue);
    }

    //删除线索
    @GetMapping(value = "deleteClue")
    public int deleteClue( String id){
        System.out.println("删除方法跳转成功");
        return clueService.deleteClue(id);
    }

    //查看选择线索信息
    @GetMapping(value = "getClueById")
    public Map<String, Object> getClueById(String id) {
        Map<String, Object> map = new HashMap<>();
        ClueVO clueVOById = clueService.getClueById(id);
        SourceAndStateVO sourceAndStateVO = clueService.getSourceAndStateVO();
        map.put("clueVO",  clueVOById);
        map.put("sourceAndStateVO",  sourceAndStateVO);
        return map;
    }
}
