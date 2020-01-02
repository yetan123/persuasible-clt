package com.simplify.service;

import com.simplify.model.entity.*;
import com.simplify.model.vo.BusinessCustomerVO;
import com.simplify.model.vo.BusinessLinkmanVO;

import java.util.List;

public interface BusinessDTOService {

    List<BusinessCustomerVO> listCustomerIDAndCustomerName();
    List<BusinessLinkmanVO> getLinkmanByCustomerId(Long CustomerId);
    List<BusinessType> listBusinessType();
    List<BusinessSource> listBusinessSource();
    List<User> listUser();
}
