package com.simplify.mapper;

import com.simplify.model.entity.ClueTask;
import com.simplify.model.vo.ClueTaskVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ClueTaskMapper extends Mapper<ClueTask> {
    List<ClueTaskVO> listClueTaskAndClueAndUser(Map<String, Object> map);

    @Select("select * from TB_CLUE_TASK where CLUE_ID = #{0}")
    List<ClueTaskVO> listClueTaskByCuleId(Long id);
}
