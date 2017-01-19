package com.lhd.web.controller.admin;

import com.lhd.core.bean.User;
import com.lhd.core.page.Page;
import com.lhd.core.page.PageHelper;
import com.lhd.web.controller.BaseController;
import com.lhd.core.service.RoleService;
import com.lhd.core.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        model.addAttribute("roles", roleService.findAllRoles());
        return "admin/user/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveOrUpdateUser(User user){
        user.setPassword(DigestUtils.md5Hex(user.getLoginName()));
        userService.saveOrUpdate(user);
        userService.addUserRole(user.getId(), user.getRoleIds());
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable(value = "id") Integer id){
        ModelAndView mav = new ModelAndView("/admin/user/add");
        mav.addObject("user", userService.getUser(id));
        mav.addObject("roles", roleService.findAllRoles());
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Integer id){
        userService.delete(id);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/isLoginNameExists", method = RequestMethod.GET)
    @ResponseBody
    public boolean isLoginNameExists(String loginName){
        User user = userService.findUserByLoginName(loginName);
        boolean flag = user == null ? false : true;
        return !flag;
    }

}

