package com.simplify.mapper;

import com.simplify.model.dto.ClueVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.entity.ClueState;
import com.simplify.model.entity.CustomerSource;
import org.apache.ibatis.annotations.Delete;
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
  //查看所有线索信息
  List<Clue> getAllClue();
  //查看线索来源
  @Select("select * from TB_CLUE_STATE")
  List<CustomerSource> getAllClueSource();
  //查询线索状态
  @Select("select * from tb_source")
  List<ClueState> getAllClueState();

}
