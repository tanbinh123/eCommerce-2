package org.spring.springboot.domain;

/**
 * 实体类
 *
 */
public class ProductType {

    private Long productTypeId;

    private String productTypeName = null;

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productId) {
        this.productTypeId = productId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productName) {
        this.productTypeName = productName;
    }
}
