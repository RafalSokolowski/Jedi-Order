package pl.rav.jediorder.web;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rav.jediorder.JediIngredient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/cook-your-own-jedi")
public class CookYourOwnJediController {

    @GetMapping
    public String showParameters (Model model) {
        List<JediIngredient> jediIngredients = Arrays.asList(
          new JediIngredient("001","R2D2", JediIngredient.Type.BLUE,550, JediIngredient.Side.LIGHT),
          new JediIngredient("002","Jabba", JediIngredient.Type.NOP,320, JediIngredient.Side.DARK),
          new JediIngredient("003","Chewbacca", JediIngredient.Type.NOP,640, JediIngredient.Side.LIGHT)
        );

//        Arrays.stream(JediIngredient.Type.values()).forEach(type->model.addAttribute(type.toString().toLowerCase(),filterByType(jediIngredients,type)));
//
//        model.addAttribute("cook-your-own-jedi",new Jedi());

        return "cook-your-own-jedi";
    }
}
