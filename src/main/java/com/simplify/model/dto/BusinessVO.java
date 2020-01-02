package com.simplify.model.dto;

import com.simplify.model.entity.Customer;
import com.simplify.model.entity.User;
import com.simplify.model.vo.CustomerBusinessVO;
import com.simplify.model.vo.UserBusinessVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Table(name="tb_business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessVO {
    @Id
    private String id;
    private String businessName;
    private String estimatedSales;
    private Date estimatedDate;
    private Double estimatedSuccess;
    private Date findDate;
    private String businessDescription;
    private String linkmanId;
    private String businessSourceId;
    private String businessTypeId;
    private String businessType;
    private String businessPhasesId;
    private String businessPhases;
    private Integer businessState;
    private Date createTime;
    private UserBusinessVO userBusinessVO;
    private CustomerBusinessVO customerBusinessVO;

    public Double getEstimatedSuccess() {
        estimatedSuccess=estimatedSuccess*100;
        return estimatedSuccess;
    }


}
