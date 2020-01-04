package com.simplify.service;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
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
}
