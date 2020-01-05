package com.simplify.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClueTaskDVO {
    private String id;
    private String taskContent;
    private String taskStartTime;
    private Integer taskState;
    private String taskFinishTime;
    private List<Long> clueIds;
    private String clueParticipant;
    private List<ClueAndTaskVO> tasks;
}
