package com.simplify.service.impl;

import com.simplify.mapper.QQMapper;
import com.simplify.model.entity.QQ;
import com.simplify.service.QQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * qq业务接口实现类
 * @author yuntian
 * @date 2020-1-4
 */
@Service
public class QQServiceImpl implements QQService {
    @Autowired
    QQMapper qqMapper;
    @Override
    public QQ selectQQByOpenId(String openId) {
        return qqMapper.selectByPrimaryKey(openId);
    }

    @Override
    public QQ selectQQByUserId(Long userId) {
        Example example = new Example(QQ.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        return qqMapper.selectOneByExample(example);
    }

    @Override
    public Integer BindingUser(QQ qq) {
        return qqMapper.insert(qq);
    }
}
