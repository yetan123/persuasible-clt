package com.simplify.mapper;

import com.simplify.model.entity.Clue;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author JoJo
 * @date 2019-12-20
 * 线索映射层
 */
@Repository
public interface ClueMapper extends Mapper<Clue> {

  List<Clue> getAllClue();
}
