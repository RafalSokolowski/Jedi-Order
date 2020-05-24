package pl.rav.jediorder.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rav.jediorder.warrior.Warriors;
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
        Warriors.printOrder(Warriors.getJedi());
        model.addAttribute("jedi", Warriors.getJedi().getWarriors().values());
        return "jediOrder";
    }

    @GetMapping("/sithOrder")
    public String toSithOrder(Model model) {
        Warriors.printOrder(Warriors.getSith());
        model.addAttribute("sith", Warriors.getSith().getWarriors().values());
        return "sithOrder";
    }

    @GetMapping("/warriors/LightSide/QuiGonJinn")
    public String toQuiGonJinn() {
        return "warriors/LightSide/QuiGonJinn";
    }
    @GetMapping("/warriors/LightSide/LukeSkywalker")
    public String LukeSkywalker() {
        return "warriors/LightSide/LukeSkywalker";
    }
    @GetMapping("/warriors/LightSide/MaceWinu")
    public String MaceWindu() {
        return "warriors/LightSide/MaceWindu";
    }
    @GetMapping("/warriors/LightSide/Obi_WanKenobi")
    public String Obi_WanKenobi() {
        return "warriors/LightSide/Obi_WanKenobi";
    }
    @GetMapping("/warriors/LightSide/SaeseeTiin")
    public String SaesseTiin() {return "warriors/LightSide/SaeseeTinn";}
    @GetMapping("/warriors/LightSide/Yoda")
    public String Yoda() {return "warriors/LightSide/Yoda";}


    @GetMapping("/warriors/DarkSide/DarthMaul")
    public String toDarthMual() {
        return "warriors/DarkSide/DarthMaul";
    }
    @GetMapping("/warriors/DarkSide/CountDooku")
    public String CountDooku() {
        return "warriors/DarkSide/CountDooku";
    }
    @GetMapping("/warriors/DarkSide/KyloRen")
    public String KyloRen() {
        return "warriors/DarkSide/KyloRen";
    }
    @GetMapping("/warriors/DarkSide/LeaderSnoke")
    public String LeaderSnoke() {
        return "warriors/DarkSide/LeaderSnoke";
    }
    @GetMapping("/warriors/DarkSide/Vader")
    public String Vader() {
        return "warriors/DarkSide/Vader";
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
//        nextWarrior.print();
        boolean flag = Warriors.addWarriorToOrder(nextWarrior);
        if (flag) log.info(nextWarrior.getName() + " was added to the " + nextWarrior.getOrder().getDesc() + " order");
        else log.error ("no warrior to add");

        Warriors.printOrder(Warriors.getJedi());
        Warriors.printOrder(Warriors.getSith());

        return "redirect:/newWarrior";
    }



    @GetMapping("/test")
    public String toTest(Warrior warrior) {
        return "test";
    }


}
