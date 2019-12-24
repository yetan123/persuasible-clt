package com.simplify.model.dto;

import com.simplify.model.entity.Customer;
import com.simplify.model.entity.Linkman;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddRequestParameterDTO {
    private Customer customer;
    private Linkman linkman;
}
