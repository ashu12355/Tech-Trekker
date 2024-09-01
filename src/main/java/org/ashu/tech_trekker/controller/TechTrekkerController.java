package org.ashu.tech_trekker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TechTrekkerController {

@GetMapping()
public String homePage() {
    return "redirect:/tech-trekker/home";
}
@GetMapping("/login-page")
public String loginPage() {
    return "login-page";
}

    
}
