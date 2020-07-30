package org.spring.springboot.service.impl;

import org.spring.springboot.dao.master.ProductDao;
import org.spring.springboot.domain.Product;
import org.spring.springboot.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Product> searchProduct(Long productId, String productName, String productTag, Long productTypeId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductTag(productTag);
        product.setProductTypeId(productTypeId);
        return productDao.searchProduct(product);
    }

    @Transactional
    @Override
    public Long insertOrUpdateProduct(Product product) {
        //test if there exist a product with same id
        if (productDao.findById(product.getProductId()).isEmpty()){
            //insert new product
            //check if null for some key value
            if (product.getProductQuantity() == null){
                product.setProductQuantity((long)0);
            }
            return productDao.saveProductById(product);
        }else{
            //update product
            //x-lock
            productDao.xlockById(product.getProductId());
            //check if not null then update
            long productId = product.getProductId();

            if (product.getProductName() != null && (! product.getProductName().equals(""))){
                productDao.updateProductName(product.getProductName(),productId);
            }
            productDao.updateOnsale(product.isProductOnsale(),productId);
            productDao.updateProductPrice(product.getProductPrice(),productId);
            if (product.getProductDescription() != null && (! product.getProductDescription().equals(""))){
                productDao.updateDescription(product.getProductDescription(),productId);
            }
            productDao.updateQuantity(product.getProductQuantity(),productId);
            if (product.getProductTag() != null && (! product.getProductTag().equals(""))){
                productDao.updateTag(product.getProductTag(),productId);
            }
            return (long)0;
        }
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
