package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author JoJo
 * @date 2019-12-20
 *
 */
@Table(name="tb_clue")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clue {
    @Id
    private Long id; //编号
    private String customerName; //客户名
    private String enterprise; //企业
    private String department; //部门
    private String position; //职位
    private char genders; //性别
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
