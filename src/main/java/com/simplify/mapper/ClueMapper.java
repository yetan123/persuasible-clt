package com.simplify.mapper;

import com.simplify.model.entity.Clue;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author JoJo
 * @date 2019-12-20
 * 线索映射层
 */
@Repository
public interface ClueMapper {
    List<Clue> getAllClue();
}
