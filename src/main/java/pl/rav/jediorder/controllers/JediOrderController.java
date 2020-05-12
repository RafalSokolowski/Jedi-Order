package pl.rav.jediorder.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rav.jediorder.warrior.Jedi;

@Controller
@Log4j2
public class JediOrderController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/jediOrder")
    public String toJediOrder(Model model) {
//        Jedi.getJedi().forEach(model::addAttribute); // InteliJ converted form: Jedi.getJedi().forEach((k, v) -> model.addAttribute(k, v));
//        model.asMap().forEach((k, v) -> log.info(k + " = " + v));
        model.addAttribute("jedi", Jedi.getJedi());
        model.asMap().values().forEach(System.out::println);
        return "jediOrder";
    }

    @GetMapping("/sithOrder")
    public String toSithOrder() {
        return "sithOrder";
    }

    @GetMapping("/warriors/LightSide/QuiGonJinn")
    public String toQuiGonJinn() {
        return "warriors/LightSide/QuiGonJinn";
    }

    @GetMapping("/warriors/DarkSide/DarthMaul")
    public String toDarthMual() {
        return "warriors/DarkSide/DarthMaul";
    }

    @GetMapping("/newWarrior")
    public String toNewWarrior () {
        System.out.println("here");
        return "newWarrior";
    }


}
