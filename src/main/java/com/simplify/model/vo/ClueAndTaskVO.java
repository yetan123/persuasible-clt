package com.simplify.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simplify.model.entity.ClueTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClueAndTaskVO {
    @Id
    private String id; //编号
    private String customerName; //客户名
    private String enterprise; //企业
    private String department; //部门
    private String position; //职位
    private String genders; //性别
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private String birthday; //生日
    private String mobilePhone; //手机
    private String email; //邮件
    private String address; //地址
    private String remark; //备注
    private String clueState; // 状态
    private Integer clueSourceId; //来源
    private Long userId; // 负责人id
    private Long createUserId; // 创建人id
}
