package com.simplify.service.impl;

import com.simplify.mapper.ProductMapper;
import com.simplify.model.dto.ProductVO;
import com.simplify.model.entity.Product;
import com.simplify.model.entity.ProductClassify;
import com.simplify.model.vo.ProductClassifyVO;
import com.simplify.service.ProductService;
import com.simplify.utils.SnowFlake;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;
    SnowFlake snowFlake = new SnowFlake(0, 0);

    @CacheEvict(value = {"listProduct"}, allEntries = true)
    @Override
    public int updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    @CacheEvict(value = {"listProductClassify"}, allEntries = true)
    @Override
    public int updateProductClassify(ProductClassify productClassify) {
        return productMapper.updateProductClassify(productClassify);
    }

    @CacheEvict(value = {"listProductClassify"}, allEntries = true)
    @Override
    public int deleteProductClassify(Long id) {
        return productMapper.deleteProductClassify(id);
    }


    @CacheEvict(value = {"listProductClassify"}, allEntries = true)
    @Override
    public int saveProductClassify(ProductClassify productClassify) {
        productClassify.setId(snowFlake.nextId());
        return productMapper.saveProductClassify(productClassify);
    }

    @Override
    public Product getProductById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value = "listProductClassify")
    @Override
    public List<ProductClassifyVO> listProductClassify() {
        return productMapper.listProductClassify();
    }

    @CacheEvict(value = {"listProduct"}, allEntries = true)
    @Override
    public int saveProduct(Product product) {
        product.setId(snowFlake.nextId());
        return productMapper.insertSelective(product);
    }

    @Cacheable("listProduct")
    @Override
    public List<ProductVO> listProduct(Integer productState) {
        return productMapper.listProduct(productState);
    }



}
