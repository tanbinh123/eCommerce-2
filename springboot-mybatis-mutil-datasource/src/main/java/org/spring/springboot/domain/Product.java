package org.spring.springboot.domain;

import java.util.Date;

/**
 * 实体类
 *
 */
public class Product {

    private Long productId;

    private Long productTypeId = (long)-1;

    private String productName = "-1";

    private String productTag = "-1";

    private String productDescription = "-1";

    private boolean productOnsale = false;

    private double productPrice = -1;

    private Long productQuantity = (long)-1;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
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
