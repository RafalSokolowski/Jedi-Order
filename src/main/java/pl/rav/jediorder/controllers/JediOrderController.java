package pl.rav.jediorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JediOrderController {

    @GetMapping("/")
    public String home () {
        return "index";
    }

    @GetMapping("/main")
    public String toMain() {

        return "main";
    }

    @GetMapping("/warriors/LightSide/QuiGonJinn")
    public String toQuiGonJinn () {
        return "warriors/LightSide/QuiGonJinn";
    }

    @GetMapping("/warriors/DarkSide/DarthMaul")
    public String toDarthMual () {
        return "warriors/DarkSide/DarthMaul";
    }


}
