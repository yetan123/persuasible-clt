package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="TB_BUSINESS_PHASES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessPhases {
    @Id
    private Long id;
    private String businessPhases;
}
