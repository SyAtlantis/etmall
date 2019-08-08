package com.entanmo.etmall.api.user.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 鉴权服务
 */
@RestController
@RequestMapping("/user/auth")
@Validated
public class UserAuthController {
}