package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_PRODUCT_CLASSIFY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductClassify {
    @Id
    private Long id;
    private String classifyName;
    private String describe;
}
