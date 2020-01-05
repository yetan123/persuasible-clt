package com.simplify.mapper;

import com.simplify.model.vo.ProductVO;
import com.simplify.model.entity.Product;
import com.simplify.model.entity.ProductClassify;
import com.simplify.model.vo.ProductClassifyVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lanmu
 */
@Repository
public interface ProductMapper extends Mapper<Product> {

    List<ProductVO> listProduct(@Param("productState") Integer productState);

    @Select("select * from TB_PRODUCT_CLASSIFY")
    List<ProductClassifyVO> listProductClassify();

    @Select(" select * from TB_PRODUCT where id = #{0}")
    ProductVO getProductVoById(Long id);

    @Insert("insert into TB_PRODUCT_CLASSIFY values(#{id},#{classifyName},#{describe})")
    int saveProductClassify(ProductClassify productClassify);
    @Update("update TB_PRODUCT_CLASSIFY set CLASSIFY_NAME = #{classifyName},DESCRIBE=#{describe} where ID = #{id}")
    int updateProductClassify(ProductClassify productClassify);
    @Delete("delete from TB_PRODUCT_CLASSIFY where id = #{0}")
    int deleteProductClassify(Long id);
}
