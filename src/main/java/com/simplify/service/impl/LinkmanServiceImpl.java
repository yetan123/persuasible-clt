package com.simplify.service.impl;

import com.simplify.mapper.LinkmanMapper;
import com.simplify.model.entity.Linkman;
import com.simplify.service.LinkmanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * 客户联系人接口类，提供对客户联系人的抽象方法
 * @author lanmu
 * @date 2019/12/18
 */
@Service
public class LinkmanServiceImpl implements LinkmanService {
    @Resource
    LinkmanMapper linkmanMapper;


    @Override
    public int saveLinkman(Linkman linkman) {
        return linkmanMapper.insert(linkman);
    }
}
