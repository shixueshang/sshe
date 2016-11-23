package com.lhd.controller.admin;

import com.alibaba.fastjson.JSON;
import com.lhd.bean.User;
import com.lhd.commons.page.Page;
import com.lhd.commons.page.PageHelper;
import com.lhd.controller.BaseController;
import com.lhd.service.RoleService;
import com.lhd.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("admin/user/list");
        Page<User> pages = userService.findPageUsers(page, size);
        mav.addObject("page", PageHelper.getPageModel(request, pages));
        mav.addObject("users", pages.getItems());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model){
        model.addAttribute("roles", JSON.toJSON(roleService.findAllRoles()));
        return "admin/user/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(User user){
        user.setPassword(DigestUtils.md5Hex(user.getLoginName()));
        userService.saveOrUpdate(user);

        return "redirect:/admin/user/list";
    }
}

