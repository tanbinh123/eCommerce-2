package org.spring.springboot.controller.admin;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

//
//    @ResponseBody
//    @RequestMapping("/helloworld")
//    public String hello() {
//        return "Hello World";
//    }
//
//    @RequestMapping("/userList2")
//    public String userList2(ModelMap map) {
//        map.addAttribute("host", "User list");
//        List<User> List = userService.listAll();
//        map.addAttribute("List", List);
//        return "admin/userList2";
//    }

//    @Value("${pageSize}")
//    private Integer pageSize;

    /**
     * 分页查询信息
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String list()
    {
//        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
//        PageRequest pageRequest = new PageRequest(pageNumber, pageSize);

        List<User> page = userService.listAll();

        return "admin/userList";
    }
}