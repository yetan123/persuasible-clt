package com.simplify.service;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.vo.ClueTaskDVO;
import com.simplify.model.vo.ClueTaskVO;
import com.simplify.model.vo.ClueVO;
import java.util.List;
import java.util.Map;

/**
 * @author JoJo
 * @date 2019-12-20
 * 线索表业务接口
 */
public interface ClueService {
    List<ClueVO> getAllClue(Map map);

    SourceAndStateVO getSourceAndStateVO();

    int addClue(Clue clue);

    int updateClue(Clue clue);

    int deleteClue(String clueId);

    ClueVO getClueById(String  id);

    List<ClueTaskDVO> findAll(ClueTaskDVO clueTaskVO);

    /*添加*/
    int insertClueTask(ClueTaskDVO clueTaskVO);
    /*修改*/
    int updateByClueId(ClueTaskDVO clueTaskDVO);
    /*删除*/
    int deleteByClueId(ClueTaskDVO clueTaskDVO);
    /*修改状态*/
    int updateByState(ClueTaskDVO clueTaskDVO);

    List<ClueTaskDVO> findByName();
}
