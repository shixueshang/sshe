package com.lhd.controller;

import com.lhd.bean.User;
import com.lhd.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * Created by lihongde on 2016/10/28 12:16
 */
@Controller
public class LoginController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, String code) {
        ModelAndView mav = new ModelAndView();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || org.apache.commons.lang.StringUtils.isEmpty(code)) {
            mav.setViewName("index");
            mav.addObject("error", "用户名/密码/验证码不能为空");
            return mav;
        }

        try {

            Subject subject = SecurityUtils.getSubject();
            if(!subject.isAuthenticated()){
                UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());
                token.setRememberMe(true);
                subject.login(token);
            }

            User user = userService.findUserByLoginName(username);

            Session session = subject.getSession(true);
            session.setAttribute("user", user);
            mav.setViewName("system/home");
            return mav;
        } catch (UnknownAccountException e) {
            mav.setViewName("index");
            mav.addObject("error", "账号不存在");
            return mav;
        } catch (IncorrectCredentialsException e) {
            mav.setViewName("index");
            mav.addObject("error", "密码错误");
            return mav;
        } catch (RuntimeException e) {
            mav.setViewName("index");
            mav.addObject("error", "未知错误，请联系管理员");
            return mav;
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        User user = super.getCurrentUser();
        if(user == null){
            return "index";
        }
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
}
