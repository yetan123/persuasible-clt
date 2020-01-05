package com.simplify.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.vo.ProductVO;
import com.simplify.model.entity.Product;
import com.simplify.model.entity.ProductClassify;
import com.simplify.model.vo.ProductClassifyVO;
import com.simplify.service.ProductService;
import com.simplify.utils.SnowFlake;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;

    @GetMapping("/listProduct")
    public PageInfo<ProductVO> listProduct(@RequestParam(defaultValue = "1", required = false) Integer pageNum,
                                           @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                           @RequestParam(defaultValue = "", required = false, name = "productStatus") Integer productStatus) {
        PageHelper.startPage(pageNum, pageSize, true);
        PageInfo<ProductVO> page = new PageInfo<>(productService.listProduct(productStatus));
        PageHelper.clearPage();
        return page;
    }

    @PostMapping("/saveProduct")
    public int saveProduct(@RequestBody Product product) {
        product.setId(new SnowFlake(0, 0).nextId());
        return productService.saveProduct(product);
    }


    @PostMapping("/updateProduct")
    public int updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/getProductById")
    public ProductVO getProductById(Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/saveProductClassify")
    public int saveProductClassify(@RequestBody ProductClassify productClassify) {
        return productService.saveProductClassify(productClassify);
    }

    @GetMapping("/listProductClassify")
    public List<ProductClassifyVO> listProductClassify() {
        return productService.listProductClassify();
    }

    @GetMapping("/deleteProductClassify")
    public int deleteProductClassify(Long id) {
        return productService.deleteProductClassify(id);
    }

    @PostMapping("/updateProductClassify")
    public int updateProductClassify(@RequestBody ProductClassify productClassify) {
        return productService.updateProductClassify(productClassify);
    }


    @GetMapping("/deleteProductById")
    public int deleteProductById(Long id) {
        return productService.deleteProduct(id);
    }
}
