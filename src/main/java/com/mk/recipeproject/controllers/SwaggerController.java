package com.mk.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class SwaggerController {

    @RequestMapping("/swagger")
    public String swagger(){
        return "redirect:/swagger-ui.html#/";
    }
    
}
