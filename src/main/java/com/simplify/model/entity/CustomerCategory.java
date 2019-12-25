package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_CUSTOMER_CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCategory {
    @Id
    private Long id;
    private String customerCategory;
}
