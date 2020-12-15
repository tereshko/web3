package me.tereshko.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FisrtController {
    @GetMapping("/first")
    public String showFirstPage() {
        return "first_page";
    }
}
