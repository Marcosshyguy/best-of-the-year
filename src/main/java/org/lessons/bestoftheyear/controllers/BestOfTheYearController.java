package org.lessons.bestoftheyear.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    @GetMapping
    public String showGreetings(Model model){
        model.addAttribute("myName", "Marco");
        return "greeting";
    }
}
