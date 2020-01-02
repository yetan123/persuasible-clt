package com.simplify.model.dto;

import com.simplify.model.entity.*;
import java.util.List;

public class BusinessDTO {
    private List<Customer> customer;
    private List<Linkman> linkman;
    private List<BusinessType> businessType;
    private List<BusinessSource> businessSource;
    private List<User> user;

    public BusinessDTO(){

    }

    public BusinessDTO(List<Customer> customer, List<Linkman> linkman, List<BusinessType> businessType, List<BusinessSource> businessSource, List<User> user) {
        this.customer = customer;
        this.linkman = linkman;
        this.businessType = businessType;
        this.businessSource = businessSource;
        this.user = user;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public List<Linkman> getLinkman() {
        return linkman;
    }

    public void setLinkman(List<Linkman> linkman) {
        this.linkman = linkman;
    }

    public List<BusinessType> getBusinessType() {
        return businessType;
    }

    public void setBusinessType(List<BusinessType> businessType) {
        this.businessType = businessType;
    }

    public List<BusinessSource> getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(List<BusinessSource> businessSource) {
        this.businessSource = businessSource;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
