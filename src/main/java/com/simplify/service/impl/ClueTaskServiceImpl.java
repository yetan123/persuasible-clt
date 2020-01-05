package com.simplify.service.impl;

import com.simplify.mapper.ClueTaskMapper;
import com.simplify.model.vo.ClueTaskVO;
import com.simplify.service.ClueTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ClueTaskServiceImpl implements ClueTaskService {
    @Resource
    ClueTaskMapper clueTaskMapper;

    @Override
    public List<ClueTaskVO> listClueTaskByCuleId(Long id) {
        return clueTaskMapper.listClueTaskByCuleId(id);
    }

    @Override
    public List<ClueTaskVO> listClueTaskAndClueAndUser(Map<String, Object> map) {
        return clueTaskMapper.listClueTaskAndClueAndUser(map);
    }
}
