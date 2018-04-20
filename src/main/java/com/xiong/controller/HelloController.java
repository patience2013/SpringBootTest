package com.xiong.controller;

import com.xiong.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${cupsize}")
    private  String cupSize;
    @Value("${age}")
    private Integer age;
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id",defaultValue = "0",required = false) Integer myId){
        return "id:"+myId;
    }
}
