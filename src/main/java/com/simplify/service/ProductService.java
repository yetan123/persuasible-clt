package com.simplify.service;

import com.simplify.model.dto.ProductVO;
import com.simplify.model.entity.Product;
import com.simplify.model.entity.ProductClassify;
import com.simplify.model.vo.ProductClassifyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductVO> listProduct(Integer productState);
    int updateProduct(Product product);
    int saveProduct(Product product);

    Product getProductById(Long id);


    List<ProductClassifyVO> listProductClassify();
    int saveProductClassify(ProductClassify productClassify);
    int updateProductClassify(ProductClassify productClassify);
    int deleteProductClassify(Long id);

}
