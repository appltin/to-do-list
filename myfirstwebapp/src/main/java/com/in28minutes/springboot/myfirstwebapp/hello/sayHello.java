package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayHello {
    @RequestMapping("say-ello")
    @ResponseBody
    public String sayhello(){
        return "say ellooooo";
    }

    @RequestMapping("say-ello-jsp")
    public String sayhellojsp(){
        return "sayHello";
    }
}
