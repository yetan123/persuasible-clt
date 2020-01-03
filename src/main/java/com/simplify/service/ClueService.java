package com.simplify.service;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueTaskDVO;
import com.simplify.model.vo.ClueTaskVO;
import com.simplify.model.vo.ClueVO;

import java.util.List;

/**
 * @author JoJo
 * @date 2019-12-20
 * 线索表业务接口
 */
public interface ClueService {
    List<ClueVO> getAllClue();

    SourceAndStateVO getSourceAndStateVO();

    int addClue(Clue clue);

    int deleteClue(String clueId);

    ClueVO getClueById(String  id);

    List<ClueTaskDVO> findAll(ClueTaskDVO clueTaskVO);

    /*添加*/
    int insertClueTask(ClueTaskDVO clueTaskVO);
    /*修改*/
    int updateByClueId(ClueTaskDVO clueTaskDVO);
    /*删除*/
    int deleteByClueId(ClueTaskDVO clueTaskDVO);

    List<ClueTaskDVO> findByName();
}
