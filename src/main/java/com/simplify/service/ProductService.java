package com.simplify.service;

import com.simplify.model.vo.ProductVO;
import com.simplify.model.entity.Product;
import com.simplify.model.entity.ProductClassify;
import com.simplify.model.vo.ProductClassifyVO;

import java.util.List;

public interface ProductService {
    List<ProductVO> listProduct(Integer productState);
    int updateProduct(Product product);
    int saveProduct(Product product);

    int deleteProduct(Long id);

    ProductVO getProductById(Long id);


    List<ProductClassifyVO> listProductClassify();
    int saveProductClassify(ProductClassify productClassify);
    int updateProductClassify(ProductClassify productClassify);
    int deleteProductClassify(Long id);



}
