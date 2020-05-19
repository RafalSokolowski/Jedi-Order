package pl.rav.jediorder.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rav.jediorder.warrior.Jedi;
import pl.rav.jediorder.warrior.Warrior;
import pl.rav.jediorder.warrior.types.*;

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
    public String toNewWarrior(Model model) {

        model.addAttribute("appearance", Appearance.values());
        model.addAttribute("gender", Gender.values());
        model.addAttribute("grade", Grade.values());
        model.addAttribute("lightsaber", Lightsaber.values());
        model.addAttribute("planet", Planet.values());
        model.addAttribute("sides", Side.values());
        model.addAttribute("species", Species.values());

        model.addAttribute("masters", Master.values());
        model.addAttribute("orders", OrderName.values());

        model.addAttribute("warrior", new Warrior());

        return "newWarrior";
    }

    @PostMapping("/newWarrior")
    public String getWarrior(Warrior nextWarrior, Errors errors, Model model) {
//        model.addAttribute("warrior", warrior);
//        if(errors.hasErrors()) {
//            log.error(errors);
//        }
//        System.out.println(model);
        System.out.println(nextWarrior.string());

//        Jedi.getJedi().entrySet().forEach(System.err::println);
//        System.out.println(warrior);
        return "redirect:/newWarrior";
    }

    @GetMapping("/test")
    public String toTest(Warrior warrior) {
        return "test";
    }


}
