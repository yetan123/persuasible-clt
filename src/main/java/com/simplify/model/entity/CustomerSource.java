package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_SOURCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSource {
    @Id
    private Long id;
    private String customerSource;
}
