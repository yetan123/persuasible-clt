package com.simplify.service;

import com.simplify.model.vo.ClueTaskVO;

import java.util.List;
import java.util.Map;

public interface ClueTaskService {
    List<ClueTaskVO> listClueTaskAndClueAndUser(Map<String, Object> map);
    List<ClueTaskVO> listClueTaskByCuleId(Long id);
}
