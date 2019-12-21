package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_CUSTOMER_STATE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerState {
    @Id
    private Long id;
    private String customerState;
    private String describe;
}
