package com.simplify.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simplify.model.entity.ClueTask;
import com.simplify.model.entity.CustomerSource;
import com.simplify.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClueVO {
    private String id; //编号
    private String customerName; //客户名
    private String enterprise; //企业
    private String department; //部门
    private String position; //职位
    private String genders; //性别
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthday; //生日
    private String mobilePhone; //手机
    private String email; //邮件
    private String address; //地址
    private String remark; //备注
    private String clueState; // 状态
    private Integer clueSourceId; //来源
    private Long userId; // 负责人id
    private Long createUserId; // 创建人id

    private CustomerSource customerSource; // 客户来源
    private User user; // 线索负责人
    private User createUser; //线索创建人
    private List<ClueTask> clueTasks; // 线索任务集合
}
