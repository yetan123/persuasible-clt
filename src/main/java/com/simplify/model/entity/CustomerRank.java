package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_CUSTOMER_RANK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRank {
    @Id
    private Long id;
    private String customerRank;
    private String describe;
}
