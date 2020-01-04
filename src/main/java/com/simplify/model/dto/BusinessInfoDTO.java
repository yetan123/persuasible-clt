package com.simplify.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 添加商机相关信息数据传输类
 * @author yuntian
 * @date 2020-1-1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfoDTO {
    private Long id;

    private String businessName;

    private BigDecimal estimatedSales;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date estimatedDate;

    private Double estimatedSuccess;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date findDate;

    private String businessDescription;

    private Long userId;

    private Long businessSourceId;

    private Long customerId;

    private String businessType;

    private String businessPhases;

    private Integer businessState;
}
