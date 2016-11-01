package com.lhd.controller.admin;

import com.lhd.bean.User;
import com.lhd.commons.page.Page;
import com.lhd.commons.page.PageHelper;
import com.lhd.controller.BaseController;
import com.lhd.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("admin/user/list");
        Page<User> pages = userService.findPageUsers(page, size);
        mav.addObject("page", PageHelper.getPageModel(request, pages));
        mav.addObject("users", pages.getItems());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(){
        return "admin/user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user){
        user.setPassword(DigestUtils.md5Hex(user.getLoginName()));
        userService.insert(user);
        return "redirect:/admin/user/list";
    }
}

