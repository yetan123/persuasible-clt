package com.simplify.service.impl;

import com.simplify.mapper.LinkmanMapper;
import com.simplify.model.entity.Linkman;
import com.simplify.service.LinkmanService;
import com.simplify.utils.SnowFlake;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    private SnowFlake snowFlake = new SnowFlake(0, 0);


    @Override
    public int deleteLinkmanByCustomerId(Long  id) {
        Linkman linkman = new Linkman();
        Example example = new Example(Linkman.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("customerId", id);
        return linkmanMapper.deleteByExample(example);
    }

    @Override
    public int saveLinkman(Linkman linkman) {
        linkman.setId(snowFlake.nextId());
        return linkmanMapper.insertSelective(linkman);
    }
}
