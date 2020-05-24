//package pl.rav.jediorder.controllers;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.rav.jediorder.warrior.Warrior;
//import pl.rav.jediorder.JediFeature;
//
//import javax.validation.Valid;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Log4j2
//@Controller
////@RequestMapping("/cook_your_own_jedi")
//public class CookYourOwnJediController {
//
//    @GetMapping
//    public String showJediForm(Model model) {
//
//        List<JediFeature> jediFeatures = Arrays.asList(
//                new JediFeature("S01", "Dark Side", JediFeature.Feature.SIDE),
//                new JediFeature("S02", "Light Side", JediFeature.Feature.SIDE),
//
//                new JediFeature("L01", "Blue", JediFeature.Feature.LIGHTSABER),
//                new JediFeature("L02", "Red", JediFeature.Feature.LIGHTSABER),
//                new JediFeature("L03", "No", JediFeature.Feature.LIGHTSABER),
//
//                new JediFeature("LeaderSnoke01", "Leader Snoke Style", JediFeature.Feature.APPEARANCE),
//                new JediFeature("LordVader01", "Lord Vader Style", JediFeature.Feature.APPEARANCE),
//                new JediFeature("SheevPalpatine01", "Sheev Palpatine Style", JediFeature.Feature.APPEARANCE),
//                new JediFeature("MasterYoda01", "Master Yoda Style", JediFeature.Feature.APPEARANCE),
//
//                new JediFeature("O1", "Assassins", JediFeature.Feature.ORDER),
//                new JediFeature("O2", "Fighters", JediFeature.Feature.ORDER),
////                new JediFeature("O4", "Testers", JediFeature.Feature.ORDER),
//                new JediFeature("O3", "Defenders", JediFeature.Feature.ORDER)
//
//        );
//
//        Arrays.stream(JediFeature.Feature.values()).forEach(f -> model.addAttribute(f.toString().toLowerCase(), filterByFeature(jediFeatures, f)));
//
//        model.addAttribute("jedi", new Warrior());
//
//        System.out.println();
//        model.asMap().forEach((k, v) -> {
//            System.out.printf("%-10s = %s\n", k, v);
//        });
//        System.out.println();
//
//        return "cook_your_own_jedi";
//    }
//
//    private List<JediFeature> filterByFeature(List<JediFeature> jediFeatures, JediFeature.Feature feature) {
//        return jediFeatures.stream().filter(f -> f.getFeature().equals(feature)).collect(Collectors.toList());
//    }
//
//
//    @PostMapping
//    public String processFreshlyBakedJedi(@Valid Warrior jedi, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            log.error("error: " + errors);
//            model.addAttribute("jedi", jedi);
//            return "cook_your_own_jedi";
//        }
////        model.addAttribute("jedi",jedi);
//        log.info("Candidate for a new Jedi processing: " + jedi);
//        return "redirect:/new_jedi_on_the_board/confirmation";
//    }
//}
