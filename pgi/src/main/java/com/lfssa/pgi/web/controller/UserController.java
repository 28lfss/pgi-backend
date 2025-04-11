package com.lfssa.pgi.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.application.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
}
