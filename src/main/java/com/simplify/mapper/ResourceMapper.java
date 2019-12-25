package com.simplify.mapper;

import com.simplify.model.entity.Resource;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 资源管理器
 * @author yuntian
 * @date 2019-12-24
 */
@Repository
public interface ResourceMapper extends Mapper<Resource> {
    List<Resource> listResourceByUserId(Long userId);
}
