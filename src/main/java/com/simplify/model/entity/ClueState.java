package com.simplify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Table(name="tb_clue_state")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClueState {
    private Integer id;
    private String stateName;
}
