package com.simplify.mapper;

import com.simplify.model.entity.QQ;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * qq数据库访问层
 * @author yuntian
 * @date 2020-1-4
 */
@Repository
public interface QQMapper extends Mapper<QQ> {
}
