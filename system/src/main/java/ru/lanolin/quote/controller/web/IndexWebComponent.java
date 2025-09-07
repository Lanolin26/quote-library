package ru.lanolin.quote.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexWebComponent {

    @GetMapping
    public String index(Model model) {
        return "index";
    }

}
