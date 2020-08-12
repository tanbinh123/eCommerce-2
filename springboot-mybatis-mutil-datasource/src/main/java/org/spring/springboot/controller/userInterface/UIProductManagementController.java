//商品管理
package org.spring.springboot.controller.userInterface;


import org.spring.springboot.dao.master.ProductDao;
import org.spring.springboot.domain.Product;
import org.spring.springboot.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/userInterface")
public class UIProductManagementController {

    @Autowired
    private ProductManagementService productManagementService;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/productManagement")
    public String listAllProductInMarket(Long productId, String productName, String productTag, Long productTypeId, Model model) {
        model.addAttribute("Product", new Product());
        List<Product> list;
        model.addAttribute("host", "搜索结果");
        list = productManagementService.searchProduct(productId, productName, productTag, productTypeId);
        model.addAttribute("list", list);
        return "userInterface/productManagement";
    }



    @PostMapping("/productManagement")
    public String productInsertOrUpdate(Model model, @ModelAttribute Product product) {
        if((product.getProductId() == null)){
            model.addAttribute("host", "ID不能为空");
            return "userInterface/inputWarning";
        }else if(product.getProductQuantity() == null ){
            model.addAttribute("host", "商品数量不能为空");
            return "userInterface/inputWarning";
        }

        productManagementService.insertOrUpdateProduct(product);
        return "redirect:/userInterface/productManagement";
    }

    @PostMapping("/productDelete")
    public String deleteUser(Model model, @ModelAttribute Product product) {
        if(product.getProductId() == null){
            model.addAttribute("host", "ID不能为空");
            return "userInterface/inputWarning";
        }
        productManagementService.deleteProduct(product.getProductId());
        return "redirect:/userInterface/productManagement";
    }

}