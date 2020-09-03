//商品管理
package org.spring.springboot.controller.admin;


import org.spring.springboot.dao.master.ProductDao;
import org.spring.springboot.domain.Product;
import org.spring.springboot.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class ProductManagementController {

    @Autowired
    private ProductManagementService productManagementService;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/productManagement")
    public String listAllProductInMarket(Long productId, String productName, String productTag, Long productTypeId, Model model) {
        model.addAttribute("Product", new Product());
        List<Product> list;
        model.addAttribute("path", "productManagement");
        Product myProduct = new Product();
        myProduct.setProductId(productId);
        myProduct.setProductName(productName);
        myProduct.setProductTag(productTag);
        myProduct.setProductTypeId(productTypeId);
        myProduct.setProductState(null);
        list = productManagementService.searchProduct(myProduct);
        model.addAttribute("list", list);
        return "admin/productManagement";
    }

}