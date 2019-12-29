package com.simplify.service;

import com.simplify.model.entity.Linkman;

import java.util.List;

/***
 * 客户联系人接口类，提供对客户联系人的抽象方法
 * @author lanmu
 * @date 2019/12/18
 */
public interface LinkmanService {
    int saveLinkman(Linkman linkman);

    int deleteLinkmanByCustomerId(Long id);
}
