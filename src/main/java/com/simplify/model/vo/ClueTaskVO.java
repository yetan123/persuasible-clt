package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClueTaskVO {
    private String id;
    private String taskContent;
    private String taskStartTime;
    private Integer taskState;
    private String taskFinishTime;
    private Long clueId;
    private String clueParticipant;
    private ClueVO clueVO;
}
