package pl.rav.jediorder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JediOrderController {

    @GetMapping("/")
    public String home () {
        return "JediOrderView";
    }
}
