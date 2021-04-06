package com.caosong.common.controller;
import com.caosong.uuid.service.UUIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author caosong
 * @Description //TODO
 * @Date 2021/4/6 16:48
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UUIDService uuidService;
    @RequestMapping(value = "/withAccount", method = RequestMethod.POST)
    public String login() {
        return "123";
    }

}
