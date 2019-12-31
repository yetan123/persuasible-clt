package com.simplify.mapper;

import com.simplify.model.entity.GitHub;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface GitHubMapper extends Mapper<GitHub> {
}
