package com.caosong.raptor.login.controller;


import com.caosong.raptor.login.service.ITbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caosong
 * @since 2021-04-08
 */
@RestController
@RequestMapping("/login/tb-user")
public class TbUserController {
    @Autowired
    private ITbUserService service;
    @RequestMapping("/test")
    public List test(){
        return service.list();
    }

}
