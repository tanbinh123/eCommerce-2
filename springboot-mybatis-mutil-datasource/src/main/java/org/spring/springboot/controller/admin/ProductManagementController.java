package org.spring.springboot.controller.admin;


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
@RequestMapping("/")
public class ProductManagementController {

    @Autowired
    private ProductManagementService productManagementService;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/productManagement")
    public String listAllProductInMarket(Long productId, Model model) {
        model.addAttribute("Product", new Product());
        List<Product> list;
        if (productId != null){
            model.addAttribute("host", "搜索结果");
            list = productManagementService.findProductById(productId);
        }else{
            model.addAttribute("host", "所有优惠券");
            list = productManagementService.listAll();
        }
        model.addAttribute("list", list);
        return "admin/productManagement";
    }



    @PostMapping("/productManagement")
    public String userRegistrationOrUpdate(Model model, @ModelAttribute Product product) {
        if((product.getProductId() == null)||product.getProductQuantity() == null ){
            return "admin/inputWarning";
        }
//        if(productManagementService.findProductById(product.getProductId()).isEmpty()){
//            productManagementService.saveProductId(product);
//        }else{
//
//            //test if posted in productManagement's params are not null
//
//            if(product.getProductName() != null && product.getProductName() != "" ) {
//                productDao.updateProductName(product.getProductName(), product.getProductId());
//            }
//
//            if(product.getProductQuantity() != null) {
//                productDao.updateQuantity(product.getProductQuantity(), product.getProductId());
//            }
//
//            if(product.getExpireDate() != null){
//                //TODO
//            }
//
//            if(product.getProductDescription() != null && product.getProductDescription() != ""){
//                productDao.updateDescription(product.getProductDescription(), product.getProductId());
//            }
//
//            productDao.updateOnsale(product.isProductOnsale(), product.getProductId());
//            productDao.updateProductPrice(product.getProductPrice(), product.getProductId());
//
//        }

        return "redirect:/productManagement";
    }

    @PostMapping("/productDelete")
    public String deleteUser(Model model, @ModelAttribute Product product) {
        if(product.getProductId() == null){
            return "admin/inputWarning";
        }
        productManagementService.deleteProduct(product.getProductId());
        return "redirect:/productManagement";
    }

}