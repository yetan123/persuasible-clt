package com.simplify.service.impl;

import com.simplify.mapper.ClueMapper;
import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {
    @Autowired
    private ClueMapper clueMapper;

    public List<ClueVO> getAllClue(){ return clueMapper.getAllClue();};

    public SourceAndStateVO getSourceAndStateVO(){
        SourceAndStateVO sourceAndStateVO = new SourceAndStateVO();
        sourceAndStateVO.setClueStates(clueMapper.getAllClueState());
        sourceAndStateVO.setCustomerSources(clueMapper.getAllClueSource());
            return sourceAndStateVO;
    }

    public int addClue(Clue clue){
        int num = clueMapper.insert(clue);
        System.out.println(num);
        return num;
    }

    public int deleteClue(String id){
        int num = clueMapper.deleteByPrimaryKey(id);
        return num;
    }

    public ClueVO getClueById(String id){
        return clueMapper.getClueById(id);
    }

}
