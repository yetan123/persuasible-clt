package com.simplify.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.entity.CustomerSource;
import com.simplify.model.vo.ClueTaskDVO;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import com.simplify.service.ClueTaskService;
import com.simplify.service.CustomerService;
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

    @Resource
    CustomerService customerService;

    @Resource
    ClueTaskService clueTaskService;

    //获取全部线索
    @PostMapping(value = "list")
    public  PageInfo getAllClue(@RequestBody Map map) throws ParseException {
        Integer pageNum = map.get("pageNum") != null ? Integer.valueOf(map.get("pageNum").toString()) : 0;
        Integer pageSize = map.get("pageSize") != null ? Integer.valueOf(map.get("pageSize").toString()) : 5;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ClueVO> pageInfo = new PageInfo(clueService.getAllClue(map));
        return pageInfo;
    }

    //获取所有来源和状态
    @GetMapping(value = "getAllSourceAndState")
    public SourceAndStateVO getAllSourceAndState(){
        return clueService.getSourceAndStateVO();
    }

    //添加线索
    @PostMapping(value = "addClue")
    public int addClue(@RequestBody Clue clue) {
        clue.setId(new SnowFlake(0, 0).nextId());
//        clueService.addClue(clue);
        return clueService.addClue(clue);
    }

    //删除线索
    @GetMapping(value = "deleteClue")
    public int deleteClue( String id){
        return clueService.deleteClue(id);
    }

    @PostMapping("/updateClue")
    public int updateClue(@RequestBody Clue clue) {
        return clueService.updateClue(clue);
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

    @GetMapping("/listSource")
    public List<CustomerSource> listSource() {
        return customerService.listCustomerSource();
    }

    private Map filterParamsConver(Map params) throws ParseException {
        if(params.get("createTime") != null) {
            Object createDate = params.get("createTime");
            if (createDate != null && createDate instanceof ArrayList) {
                ArrayList listDate = (ArrayList) params.get("createTime");
                params.put("createStartDate", convertTime(listDate.get(0).toString()));
                params.put("createEndDate", convertTime(listDate.get(1).toString()));
            } else {
                params.put("createStartDate", null);
                params.put("createEndDate", null);
            }
        }
        return params;
    }

    //跟进任务
    @GetMapping(value = "/getTask")
    public List<ClueTaskDVO> getTask(ClueTaskDVO clueTaskVO)  {
        List<ClueTaskDVO> list= clueService.findAll(clueTaskVO);
        return clueService.findAll(clueTaskVO);
    }
    //下拉
    @GetMapping(value = "/getName")
    public List<ClueTaskDVO> getName() {
        return clueService.findByName();
}
    /*添加任务*/
    @PostMapping("/add")
    public int add(@RequestBody ClueTaskDVO clueTaskVO) throws ParseException {
        long longVal =new SnowFlake(0,0).nextId();
        String id=String.valueOf(longVal);
        clueTaskVO.setId(id);
        clueTaskVO.setTaskStartTime(convertTime(clueTaskVO.getTaskStartTime()));
        clueTaskVO.setTaskFinishTime(convertTime(clueTaskVO.getTaskFinishTime()));
        return clueService.insertClueTask(clueTaskVO);
    }

    @PostMapping("/update")
    public int update(@RequestBody ClueTaskDVO clueTaskVO) throws ParseException {
        clueTaskVO.setTaskStartTime(convertTime(clueTaskVO.getTaskStartTime()));
        clueTaskVO.setTaskFinishTime(convertTime(clueTaskVO.getTaskFinishTime()));
        return clueService.updateByClueId(clueTaskVO);
    }
    @PostMapping("/updateState")
    public int updatestate(@RequestBody ClueTaskDVO clueTaskVO){
        return clueService.updateByState(clueTaskVO);
    }

    @GetMapping("/deleteById")
    public int deleteUser(ClueTaskDVO clueTaskVO){
        return clueService.deleteByClueId(clueTaskVO);
    }

    private String convertTime(String time) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date parse = df.parse(time);
        SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        Date date1 = df1.parse(parse.toString());
        df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date1);
    }

}
