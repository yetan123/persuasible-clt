package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_customer_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTasks {
    @Id
    private Long id;
    private Long customerId;
    private Long linkmanId;
    private String taskName;
    private String taskContent;
    private Date taskStartTime;
    private Date taskEndTime;
    private String taskParticipant;

    @Override
    public String toString() {
        return "CustomerTasks{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", linkmanId=" + linkmanId +
                ", taskName='" + taskName + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", taskStartTime=" + taskStartTime +
                ", taskEndTime=" + taskEndTime +
                ", taskParticipant='" + taskParticipant + '\'' +
                '}';
    }
}
