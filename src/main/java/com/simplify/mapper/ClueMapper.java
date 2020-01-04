package com.simplify.mapper;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.entity.ClueState;
import com.simplify.model.entity.CustomerSource;
import com.simplify.model.vo.ClueVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author JoJo
 * @date 2019-12-20
 * 线索映射层
 */
@Repository
public interface ClueMapper extends Mapper<Clue> {
  //查看所有线索信息
  List<ClueVO> getAllClue(Map map);
  //查看线索来源
  @Select("select * from tb_source")
  List<CustomerSource> getAllClueSource();
  //查询线索状态
  @Select("select * from TB_CLUE_STATE")
  List<ClueState> getAllClueState();

  ClueVO getClueById(String id);
}
