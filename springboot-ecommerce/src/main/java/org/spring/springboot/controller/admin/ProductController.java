//商品管理
package org.spring.springboot.controller.admin;


import org.spring.springboot.dao.master.ProductDao;
import org.spring.springboot.domain.Product;
import org.spring.springboot.domain.Result;
import org.spring.springboot.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private ProductManagementService productManagementService;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/products")
    public String listAllProductInMarket(Long productId, String productName, String productTag, Long productTypeId, Model model) {
        model.addAttribute("path", "products");
        return "admin/products";
    }

    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallGoodsService.getNewBeeMallGoodsPage(pageUtil));
    }

}