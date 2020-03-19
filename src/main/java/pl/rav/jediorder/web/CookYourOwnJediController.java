package pl.rav.jediorder.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rav.jediorder.Jedi;
import pl.rav.jediorder.JediFeature;
import pl.rav.jediorder.JediSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
@RequestMapping("/cook_your_own_jedi")
public class CookYourOwnJediController {

    @GetMapping
    public String showParameters(Model model) {

//        List<JediSet> jediSets = Arrays.asList(
//                new JediSet("Set_Anakin_Skywalker", JediSet.Type.BLUE, 550, JediSet.Side.LIGHT),
//                new JediSet("Set_Chewbacca",        JediSet.Type.NOP,  640, JediSet.Side.LIGHT),
//                new JediSet("Set_Obi_Wan_Kenobi",   JediSet.Type.BLUE, 870, JediSet.Side.LIGHT),
//                new JediSet("Set_Han_Solo",         JediSet.Type.BLUE, 640, JediSet.Side.LIGHT),
//                new JediSet("Set_Princess_Leia",    JediSet.Type.BLUE, 340, JediSet.Side.LIGHT),
//
//                new JediSet("Set_Darth_Maul",       JediSet.Type.RED, 620, JediSet.Side.DARK),
//                new JediSet("Set_Kylo_Ren",         JediSet.Type.RED, 570, JediSet.Side.DARK),
//                new JediSet("Set_Lord_Vader",       JediSet.Type.RED, 890, JediSet.Side.DARK),
//                new JediSet("Set_Sheev_Palpatine",  JediSet.Type.NOP, 720, JediSet.Side.DARK),
//                new JediSet("Set_Leader_Snoke",     JediSet.Type.RED, 820, JediSet.Side.DARK)
//                );
//
//        JediSet.Side[] sides = JediSet.Side.values();
//        for (JediSet.Side s : sides) {
//            model.addAttribute(s.toString().toLowerCase(),filterBySide(jediSets,s));
//        }
//
//        model.addAttribute("cook_your_own_jedi",new Jedi());

        List<JediFeature> jediFeatures = Arrays.asList(
                new JediFeature("S01", "Dark Side", JediFeature.Feature.SIDE),
                new JediFeature("S02", "Light Side", JediFeature.Feature.SIDE),

                new JediFeature("L01", "Blue", JediFeature.Feature.LIGHTSABER),
                new JediFeature("L02", "Red", JediFeature.Feature.LIGHTSABER),
                new JediFeature("L03", "No", JediFeature.Feature.LIGHTSABER),

                new JediFeature("S01", "100", JediFeature.Feature.STRENGTH),
                new JediFeature("S02", "300", JediFeature.Feature.STRENGTH),
                new JediFeature("S03", "500", JediFeature.Feature.STRENGTH),
                new JediFeature("S04", "800", JediFeature.Feature.STRENGTH),
                new JediFeature("S05", "950", JediFeature.Feature.STRENGTH),

                new JediFeature("LeaderSnoke", "Leader Snoke", JediFeature.Feature.APPEARANCE),
                new JediFeature("LordVader", "Lord Vader", JediFeature.Feature.APPEARANCE),
                new JediFeature("SheevPalpatine", "Sheev Palpatine", JediFeature.Feature.APPEARANCE),
                new JediFeature("Yoda", "Master Yoda", JediFeature.Feature.APPEARANCE)
        );

        Arrays.stream(JediFeature.Feature.values()).forEach(f->model.addAttribute(f.toString().toLowerCase(), filterByFeature(jediFeatures,f)));

        model.addAttribute("cook_your_own_jedi",new Jedi());

        return "cook_your_own_jedi";
    }

    private List<JediFeature> filterByFeature(List<JediFeature> jediFeatures, JediFeature.Feature feature) {
        return jediFeatures.stream().filter(f->f.getFeature().equals(feature)).collect(Collectors.toList());
    }

//    private List<JediSet> filterBySide(List<JediSet> jediSets, JediSet.Side side) {
//        return jediSets.stream().filter(s->s.getSide().equals(side)).collect(Collectors.toList());
//    }

    @PostMapping
    public String processFreshlyBakedJedi (Jedi jedi) {
        log.info("processing of the candidate for new Jedi: " + jedi);
        return "redirect:/new_jedi_on_the_board/confirmation";
    }
}
