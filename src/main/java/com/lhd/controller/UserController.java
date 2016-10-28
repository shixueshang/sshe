package com.lhd.controller;

import com.lhd.util.RandomCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{

	@RequestMapping("/getCode")
	public void getCode() throws Exception {
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
}

