package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 64274 on 2019/2/24.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/24---20:49
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    // http://localhost:8217/hello/test1
    @GetMapping("/test1")
    public String test1(ModelMap map) {
        map.addAttribute("hello", "asdkfjdsfkdddd");
        return "haha";
    }
}