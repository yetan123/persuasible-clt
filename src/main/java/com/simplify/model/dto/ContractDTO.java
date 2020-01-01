package com.simplify.model.dto;

import com.simplify.model.entity.*;

import java.util.List;

public class ContractDTO {
    private List<Customer> customer;
    private List<Linkman> linkman;
    private List<Business> business;
    private List<ContractType> contractType;
    private List<User> user;
    private List<ContractState> contractState;
    private String contractNo;

    public ContractDTO() {
    }

    public ContractDTO(List<Customer> customer, List<Linkman> linkman, List<Business> business, List<ContractType> contractType, List<User> user, List<ContractState> contractState, String contractNo) {
        this.customer = customer;
        this.linkman = linkman;
        this.business = business;
        this.contractType = contractType;
        this.user = user;
        this.contractState = contractState;
        this.contractNo = contractNo;
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

    public List<Business> getBusiness() {
        return business;
    }

    public void setBusiness(List<Business> business) {
        this.business = business;
    }

    public List<ContractType> getContractType() {
        return contractType;
    }

    public void setContractType(List<ContractType> contractType) {
        this.contractType = contractType;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<ContractState> getContractState() {
        return contractState;
    }

    public void setContractState(List<ContractState> contractState) {
        this.contractState = contractState;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
}
