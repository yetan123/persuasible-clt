package com.simplify.mapper;

import com.simplify.model.dto.SourceAndStateVO;
import com.simplify.model.entity.Clue;
import com.simplify.model.entity.ClueState;
import com.simplify.model.entity.ClueTask;
import com.simplify.model.entity.CustomerSource;
import org.apache.ibatis.annotations.Delete;
import com.simplify.model.vo.ClueAndTaskVO;
import com.simplify.model.vo.ClueTaskDVO;
import com.simplify.model.vo.ClueTaskVO;
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

  /*任务*/
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
