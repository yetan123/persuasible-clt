package com.simplify.model.dto;

import com.simplify.model.entity.ClueState;
import com.simplify.model.entity.CustomerSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceAndStateVO {
    private List<ClueState> clueStates;
    private List<CustomerSource> customerSources;
}
