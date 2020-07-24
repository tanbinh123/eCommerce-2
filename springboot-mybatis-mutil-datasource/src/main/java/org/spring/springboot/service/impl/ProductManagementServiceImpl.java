package org.spring.springboot.service.impl;

import org.spring.springboot.dao.master.ProductDao;
import org.spring.springboot.domain.Product;
import org.spring.springboot.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务逻辑实现类
 *
 */
@Service
public class ProductManagementServiceImpl implements ProductManagementService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findProductById(Long productId) {
        return productDao.findById(productId);
    }

    @Override
    public List<Product> searchProduct(Long productId, String productName, String productTag) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductTag(productTag);
        return productDao.searchProduct(product);
    }

    @Override
    public Long saveProductId(Product product) {
        return productDao.saveProductById(product);
    }

    @Override
    public List<Product> listAll() {
        return productDao.listAll();
    }

    @Override
    public Long deleteProduct(Long productId) {
        return productDao.deleteProduct(productId);
    }

}
