package xyz.wmlz.restdemo.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
class DemoController {
    @GetMapping("/test1")
    @RequiresRoles("123")
    String test1() {
        return "test1";
    }

    @GetMapping("test2")
    String test2() {
        return "test2";
    }

    //test
}