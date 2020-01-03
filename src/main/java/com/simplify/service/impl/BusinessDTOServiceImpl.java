package com.simplify.service.impl;

import com.simplify.mapper.BusinessDTOMapper;
import com.simplify.model.entity.*;
import com.simplify.model.vo.BusinessCustomerVO;
import com.simplify.model.vo.BusinessLinkmanVO;
import com.simplify.service.BusinessDTOService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessDTOServiceImpl implements BusinessDTOService {

    @Resource
    private BusinessDTOMapper businessDTOMapper;

    @Override
    public List<BusinessCustomerVO> listCustomerIDAndCustomerName() {
        return businessDTOMapper.listCustomerIDAndCustomerName();
    }

    @Override
    public List<BusinessLinkmanVO> getLinkmanByCustomerId(Long CustomerId) { return businessDTOMapper.getLinkmanByCustomerId(CustomerId); }

    @Override
    public List<BusinessType> listBusinessType() {
        return businessDTOMapper.listBusinessType();
    }

    @Override
    public List<BusinessSource> listBusinessSource() {
        return businessDTOMapper.listBusinessSource();
    }

    @Override
    public List<User> listUser() {
        return businessDTOMapper.listUser();
    }
}
