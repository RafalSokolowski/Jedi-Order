//package pl.rav.jediorder.controllers;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.rav.jediorder.warrior.Warrior;
//
//@Log4j2
//@Controller
//@RequestMapping("/new_jedi_on_the_board")
//public class NewJediController {
//
//    @GetMapping("confirmation")
//    public String processNewJedi (Model model) {
//        model.addAttribute("New Jedi", new Warrior());
//        return "new_jedi_confirmation";
//    }
//
//}
