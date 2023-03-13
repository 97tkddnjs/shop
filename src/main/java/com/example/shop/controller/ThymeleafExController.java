package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("thymeleaf")
public class ThymeleafExController {

    @GetMapping("ex07")
    public String thymeex07() {
        return "thymeleafEX07";
    }
}
