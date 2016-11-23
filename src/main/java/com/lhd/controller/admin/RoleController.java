package com.lhd.controller.admin;

import com.lhd.bean.Role;
import com.lhd.bean.User;
import com.lhd.commons.page.Page;
import com.lhd.commons.page.PageHelper;
import com.lhd.controller.BaseController;
import com.lhd.service.RoleService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by lihongde on 2016/11/23 19:14
 */
@Controller
@RequestMapping(value = "/admin/role")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("admin/role/list");
        Page<Role> pages = roleService.findPageRoles(page, size);
        mav.addObject("page", PageHelper.getPageModel(request, pages));
        mav.addObject("roles", pages.getItems());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createRole(){
        return "admin/role/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRole(Role role){
        roleService.saveOrUpdate(role);
        return "redirect:/admin/user/list";
    }
}
