package com.simplify.service.impl;

import com.simplify.mapper.ClueMapper;
import com.simplify.model.entity.Clue;
import com.simplify.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {
    @Autowired
    private ClueMapper clueMapper;

    public List<Clue> getAllClue(){ return clueMapper.getAllClue();};
}
