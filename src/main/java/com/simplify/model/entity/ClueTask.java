package com.simplify.model.entity;

import com.simplify.model.vo.ClueVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

/**
 * 线索任务
 */
@Table(name="tb_clue_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClueTask {
    private Long id;
    private String taskContent;
    private Date taskStartTime;
    private Integer taskState;
    private Date taskFinishTime;
    private Long clueIds;
    private String clueParticipant;
    private ClueVO clue;
}
