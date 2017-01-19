package com.lhd.web.controller.system;

import com.lhd.core.bean.User;
import com.lhd.web.controller.BaseController;
import com.lhd.core.util.RandomCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


/**
 * Created by lihongde on 2016/10/28 12:16
 */
@Controller
public class LoginController extends BaseController {


    /**
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    /**
     * 获得图片验证码
     * @throws Exception
     */
    @RequestMapping(value = "/login/getVerifyCode", method = RequestMethod.GET)
    public void getVerifyCode() throws Exception {
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        response.setBufferSize(2048);
        RandomCode rCode = new RandomCode();
        BufferedImage image = rCode.createImage();
        String randomCode = RandomCode.strCode;
        session.setAttribute("randomCode", randomCode);
        ImageIO.write(image,"JPEG",response.getOutputStream());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, String code) {
        ModelAndView mav = new ModelAndView();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || org.apache.commons.lang.StringUtils.isEmpty(code)) {
            mav.setViewName("index");
            mav.addObject("error", "用户名/密码/验证码不能为空");
            return mav;
        }

        String randomCode = (String)session.getAttribute("randomCode");
        if(!code.toUpperCase().equals(randomCode)){
            mav.setViewName("index");
            mav.addObject("error", "验证码输入错误");
            return mav;
        }

        try {

            Subject subject = SecurityUtils.getSubject();
            if(!subject.isAuthenticated()){
                UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password).toCharArray());
                token.setRememberMe(true);
                subject.login(token);
            }

            mav.setViewName("system/home");
            return mav;
        } catch (UnknownAccountException e) {
            mav.setViewName("index");
            mav.addObject("error", "账号不存在或已失效");
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
