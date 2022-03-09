package cn.com.sise.welfare.controller.fronted;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lth
 * @Date: 2022/03/08/22:08
 * @Description:
 */
@Controller
public class FrontedPageController {
    //登录后跳转到前端页面
    @GetMapping("/user")
    public String toFronted(){
        return "/fronted/index";
    }
}
