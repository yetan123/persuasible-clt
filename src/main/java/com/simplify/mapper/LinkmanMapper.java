package com.simplify.mapper;

import com.simplify.model.entity.Linkman;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface  LinkmanMapper extends Mapper<Linkman> {
    /**
     * 根据一个客户id查询多个联系人
     * @param customerId
     * @return
     */
    @Select("select * from tb_linkman where id = #{0}")
    List<Linkman> listLinkmansByCustomerId(Long customerId);
}
