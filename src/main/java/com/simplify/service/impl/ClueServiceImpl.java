package com.simplify.service.impl;

import com.simplify.mapper.ClueMapper;
import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueVO;
import com.simplify.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClueServiceImpl implements ClueService {
    @Autowired
    private ClueMapper clueMapper;

    @Cacheable(value = "getAllClue")
    @Override
    public List<ClueVO> getAllClue(Map map){ return clueMapper.getAllClue(map);};

    @Override
    public SourceAndStateVO getSourceAndStateVO(){
        SourceAndStateVO sourceAndStateVO = new SourceAndStateVO();
        sourceAndStateVO.setClueStates(clueMapper.getAllClueState());
        sourceAndStateVO.setCustomerSources(clueMapper.getAllClueSource());
            return sourceAndStateVO;
    }

    @CacheEvict(value = {"getAllClue"}, allEntries = true)
    @Override
    public int updateClue(Clue clue) {
        return clueMapper.updateByPrimaryKeySelective(clue);
    }

    @CacheEvict(value = {"getAllClue"}, allEntries = true)
    @Override
    public int addClue(Clue clue){
        int num = clueMapper.insert(clue);
        return num;
    }

    @CacheEvict(value = {"getAllClue"}, allEntries = true)
    @Override
    public int deleteClue(String id){
        int num = clueMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public ClueVO getClueById(String id){
        return clueMapper.getClueById(id);
    }

}
