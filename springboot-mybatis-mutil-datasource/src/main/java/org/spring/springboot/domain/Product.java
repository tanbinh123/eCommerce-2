package org.spring.springboot.domain;

import java.util.Date;

/**
 * 实体类
 *
 */
public class Product {

    private Long productId;

    private String productName;

    private String productTag;

    private String productDescription;

    private boolean productOnsale;

    private double productPrice;

    private Long productQuantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean isProductOnsale() {
        return productOnsale;
    }

    public void setProductOnsale(boolean productOnsale) {
        this.productOnsale = productOnsale;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductTag() {
        return productTag;
    }

    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }
}
