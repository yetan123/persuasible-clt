package com.simplify.mapper;

import com.simplify.model.entity.BusinessTask;
import com.simplify.model.vo.PrincipalBusinessTaskVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商机任务持久层
 * @author yuntian
 * @date 2020-1-3
 */
@Repository
public interface BusinessTaskMapper extends Mapper<BusinessTask> {
    @Select("select consumer.id,consumer.username from tb_business_task task " +
            "left join tb_business_task_principal task_principal " +
            "on task.id = task_principal.task_id inner join tb_user consumer " +
            "on task_principal.user_id = consumer.id where task.id = #{id}")
    List<PrincipalBusinessTaskVO> listBusinessTaskById(Long id);

    @Select("select id,username from tb_user")
    List<PrincipalBusinessTaskVO> listUserBusinessTaskVO();

    @Insert("insert into tb_business_task (id,task_content,task_time,task_finish_time,business_id,task_state)values(#{id},#{taskContent},#{taskTime},#{taskFinishTime},#{businessId},#{taskState})")
    Integer addBusinessTask(BusinessTask businessTask);

    @Select("select  id,task_content,task_time,task_finish_time,business_id,task_state from tb_business_Task where business_id = #{businessId}")
    List<BusinessTask> listBusinessTaskByBusinessId(Long businessId);

    @Update("update TB_BUSINESS_TASK set task_state = 1 where id = #{id}")
    Integer changeBusinessTaskById(Long id);
}
