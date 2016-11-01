package com.lhd.controller.system;

import com.lhd.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lihongde on 2016/11/1 16:13.
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController extends BaseController {

    @RequestMapping(value = "monitoring", method = RequestMethod.GET)
    public String druid(){
        return "system/druid";
    }
}
