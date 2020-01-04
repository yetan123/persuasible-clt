package com.simplify.controller;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueAndTaskVO;
import com.simplify.model.vo.ClueTaskDVO;
import com.simplify.model.vo.ClueTaskVO;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import com.simplify.utils.SnowFlake;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    //跟进任务
    @GetMapping(value = "/getTask")
    public List<ClueTaskDVO> getTask(ClueTaskDVO clueTaskVO)  {
        System.out.println(clueTaskVO);
        List<ClueTaskDVO> list= clueService.findAll(clueTaskVO);
        System.out.println(list);
        return clueService.findAll(clueTaskVO);
    }
    //下拉
    @GetMapping(value = "/getName")
    public List<ClueTaskDVO> getName() {
        System.out.println(clueService.findByName());
        return clueService.findByName();
}
    /*添加任务*/
    @PostMapping("/add")
    public int add(@RequestBody ClueTaskDVO clueTaskVO) throws ParseException {
        System.out.println("进入添加");
        long longVal =new SnowFlake(0,0).nextId();
        String id=String.valueOf(longVal);
        clueTaskVO.setId(id);
        clueTaskVO.setTaskStartTime(convet(clueTaskVO.getTaskStartTime()));
        clueTaskVO.setTaskFinishTime(convet(clueTaskVO.getTaskFinishTime()));
        System.out.println(clueTaskVO);
        return clueService.insertClueTask(clueTaskVO);
    }

    @PostMapping("/update")
    public int update(@RequestBody ClueTaskDVO clueTaskVO) throws ParseException {
        System.out.println("进入修改方法");
        System.out.println(clueTaskVO);
        clueTaskVO.setTaskStartTime(convet(clueTaskVO.getTaskStartTime()));
        clueTaskVO.setTaskFinishTime(convet(clueTaskVO.getTaskFinishTime()));
        System.out.println(clueTaskVO);
        return clueService.updateByClueId(clueTaskVO);
    }
    @PostMapping("/updateState")
    public int updatestate(@RequestBody ClueTaskDVO clueTaskVO){
        System.out.println("进入修改状态方法");
        System.out.println(clueTaskVO);
        return clueService.updateByState(clueTaskVO);
    }

    @GetMapping("/deleteById")
    public int deleteUser(ClueTaskDVO clueTaskVO){
        System.out.println("进入删除方法");
        return clueService.deleteByClueId(clueTaskVO);
    }

    private String convet(String time) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date parse = df.parse(time);
        SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        Date date1 = df1.parse(parse.toString());
        df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date1);
    }
}
