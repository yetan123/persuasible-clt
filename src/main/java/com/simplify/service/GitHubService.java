package com.simplify.service;

import com.simplify.model.entity.GitHub;

/**
 * github业务接口
 * @author yuntian
 * @date 2019-12-30
 */
public interface GitHubService {
    GitHub selectGitHubById(Long id);

    GitHub findGitHubByUserId(Long userId);

    Integer addGitHub(GitHub gitHub);
}
