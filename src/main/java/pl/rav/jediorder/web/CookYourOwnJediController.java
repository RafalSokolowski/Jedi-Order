package pl.rav.jediorder.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rav.jediorder.Jedi;
import pl.rav.jediorder.JediSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
@RequestMapping("/cook-your-own-jedi")
public class CookYourOwnJediController {

    @GetMapping
    public String showParameters(Model model) {
        List<JediSet> jediSets = Arrays.asList(
                new JediSet("Set_Anakin_Skywalker", JediSet.Type.BLUE, 550, JediSet.Side.LIGHT),
                new JediSet("Set_Chewbacca",        JediSet.Type.NOP,  640, JediSet.Side.LIGHT),
                new JediSet("Set_Obi_Wan_Kenobi",   JediSet.Type.BLUE, 870, JediSet.Side.LIGHT),
                new JediSet("Set_Han_Solo",         JediSet.Type.BLUE, 640, JediSet.Side.LIGHT),
                new JediSet("Set_Princess_Leia",    JediSet.Type.BLUE, 340, JediSet.Side.LIGHT),

                new JediSet("Set_Darth_Maul",       JediSet.Type.RED, 620, JediSet.Side.DARK),
                new JediSet("Set_Kylo_Ren",         JediSet.Type.RED, 570, JediSet.Side.DARK),
                new JediSet("Set_Lord_Vader",       JediSet.Type.RED, 890, JediSet.Side.DARK),
                new JediSet("Set_Sheev_Palpatine",  JediSet.Type.NOP, 720, JediSet.Side.DARK),
                new JediSet("Set_Leader_Snoke",     JediSet.Type.RED, 820, JediSet.Side.DARK)
                );

//        Arrays.stream(JediSet.Side.values()).forEach(type->model.addAttribute(type.toString().toLowerCase(),filterByType(jediSets,type)));
        JediSet.Side[] sides = JediSet.Side.values();
        for (JediSet.Side s : sides) {
            model.addAttribute(s.toString().toLowerCase(),filterBySide(jediSets,s));
        }

        model.addAttribute("cook-your-own-jedi",new Jedi());

        return "cook-your-own-jedi";
    }

    private List<JediSet> filterBySide(List<JediSet> jediSets, JediSet.Side side) {
        return jediSets.stream().filter(s->!s.getSide().equals(side)).collect(Collectors.toList());
    }

}
