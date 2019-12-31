package com.simplify.service.impl;

import com.simplify.mapper.GitHubMapper;
import com.simplify.model.entity.GitHub;
import com.simplify.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * github业务实现类
 * @author yuntian
 * @date 2019-12-30
 */
@Service
public class GitHubServiceImpl implements GitHubService {
    @Autowired
    private GitHubMapper gitHubMapper;
    @Override
    public GitHub selectGitHubById(Long id) {
        return gitHubMapper.selectByPrimaryKey(id);
    }

    @Override
    public GitHub findGitHubByUserId(Long userId) {
        Example example  = new Example(GitHub.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        return gitHubMapper.selectOneByExample(example);
    }

    @Override
    public Integer addGitHub(GitHub gitHub) {
        return gitHubMapper.insertSelective(gitHub);
    }

}
