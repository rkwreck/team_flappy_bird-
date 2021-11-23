package com.nighthawk.csa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/ourPurpose")
    public String ourPurpose(Model model) {
        return "ourPurpose";
    }

    @GetMapping("/aboutus")
    public String aboutus(Model model) {
        return "aboutus";
    }

    @GetMapping("/games")
    public String games(Model model) {
        return "games";
    }

    @GetMapping("/game1")
    public String game1(Model model) {
        return "game1";
    }

    @GetMapping("/greetAdi")
    public String greetAdi(Model model) {
        return "greetAdi";
    }

    @GetMapping("/greetChenxin")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greetChenxin";
    }

    @GetMapping("/greetPrisha")
    public String greetPrisha(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greetPrisha";
    }


    @GetMapping("/greetRini")
    public String greetRini(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        return "greetRini";
    }

}