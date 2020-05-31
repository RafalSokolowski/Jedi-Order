package pl.rav.jediorder.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pl.rav.jediorder.support.RequestToSwapiID;
import pl.rav.jediorder.support.RequestToSwapiSEARCH;
import pl.rav.jediorder.users.NewUser;
import pl.rav.jediorder.warrior.SwapiWarriorByID;
import pl.rav.jediorder.warrior.SwapiWarriorBySearch;
import pl.rav.jediorder.warrior.Warriors;
import pl.rav.jediorder.warrior.Warrior;
import pl.rav.jediorder.warrior.types.*;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@Log4j2

//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class JediOrderController {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
    @Autowired
    public JediOrderController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/login")
    public String login() {
//        log.info("users: " + inMemoryUserDetailsManager.loadUserByUsername("admin"));
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("newUser", new NewUser());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute NewUser newUser, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            log.error("registration error: " + errors);
            return "register";
        }
        log.info("Following user has just been registered: " + newUser);
        model.addAttribute("registeredUser", newUser);

//        SecurityProperties.User user = new SecurityProperties.User();
//        user.setName(newUser.getFirstName() + " " + newUser.getLastName());
//        user.setPassword(newUser.getPassword());
//        user.setRoles(Arrays.asList("USER"));
//        log.info("New user ready to be added: " + user.getName() +", " + user.getPassword());

        UserDetails userDetails = User
                .withUsername(newUser.getFirstName())
                .password(newUser.getPassword())
                .roles("USER")
                .build();

        inMemoryUserDetailsManager.createUser(userDetails);



        return "login";
    }


//    @PostMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("newUser", new User());
//        return "register";
//    }


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

    @GetMapping("/warriors/DarkSide/DarthMaul")
    public String toDarthMual() {
        return "warriors/DarkSide/DarthMaul";
    }


    @GetMapping("/swapi")
    public String toSwapi(Model model) {
        model.addAttribute("requestToSwapiID", new RequestToSwapiID());
        model.addAttribute("requestToSwapiSEARCH", new RequestToSwapiSEARCH());
        return "swapi";
    }


    //    @PostMapping(value = "/swapi", params = "action = byID")
    @PostMapping(value = "/swapiByID")
//    public String infoSwapiByID(@Valid @ModelAttribute RequestToSwapi requestToSwapiID, BindingResult bindingResult, Model model) {
    public String infoSwapiByID(@ModelAttribute @Valid RequestToSwapiID requestToSwapiID, BindingResult bindingResult, Model model) {
        log.info("what was the ID: " + requestToSwapiID.getRequestID());

//        new RequestIdValidator().validate(requestToSwapiID, bindingResult);

//        if (isStringParsableToNumberAndInRange(request.getRequestID(), 1, 83)) {
//            SwapiWarrior swapiWarrior = new RestTemplate().getForObject("https://swapi.dev/api/people/{id}/", SwapiWarrior.class, request.getRequestID());
//            log.info("Added to model \"" + swapiWarrior.getName() + "\": " + swapiWarrior);
//            model.addAttribute("swapiWarrior", swapiWarrior);
//            return "swapi_character";
//        }
//        log.error("ID \"" + request.getRequestID() + "\" is not correct");
//        return "redirect:/swapi";

        if (bindingResult.hasErrors()) {
            log.error("infoSwapiByID error: " + bindingResult);
            return "swapi";
        }

        SwapiWarriorByID swapiWarriorByID = new RestTemplate().getForObject("https://swapi.dev/api/people/{id}/", SwapiWarriorByID.class, requestToSwapiID.getRequestID());
        log.info("Added to model \"" + swapiWarriorByID.getName() + "\": " + swapiWarriorByID);
        model.addAttribute("swapiWarrior", swapiWarriorByID);

//        SwapiWarriorBySearch swapiWarriorBySearch = new RestTemplate().getForObject("https://swapi.dev/api/people/?search={fraze}", SwapiWarriorBySearch.class, requestToSwapiID.getRequestSEARCH());
//        log.info("Found: " + Arrays.toString(swapiWarriorBySearch.getResults()));
//        model.addAttribute("swapiWarrior", swapiWarriorBySearch.);
//        log.info("Added to model \"" + swapiWarriorBySearch.getName() + "\": " + swapiWarriorByID);

        return "swapi_character";
    }

    //    @PostMapping(value = "/swapi", params = "action = bySEARCH")
    @PostMapping(value = "/swapiBySEARCH")
    public String infoSwapiBySEARCH(@ModelAttribute @Valid RequestToSwapiSEARCH requestToSwapiSEARCH, BindingResult bindingResult, Model model) {
        log.info("what was the search fraze: " + requestToSwapiSEARCH.getRequestSEARCH());

        if (bindingResult.hasErrors()) {
            log.error("infoSwapiBySEARCH error: " + bindingResult);
            return "swapi";
        }

        SwapiWarriorBySearch swapiWarriorBySEARCH = new RestTemplate().getForObject("https://swapi.dev/api/people/?search={search}", SwapiWarriorBySearch.class, requestToSwapiSEARCH.getRequestSEARCH());
        log.info("Added to model: " + Arrays.toString(swapiWarriorBySEARCH.getResults()));
        if (swapiWarriorBySEARCH.getResults().length == 0) {
            model.addAttribute("swapiWarrior", "empty");
            model.addAttribute("searchFraze", requestToSwapiSEARCH.getRequestSEARCH());
        } else {
            model.addAttribute("swapiWarrior", swapiWarriorBySEARCH.getResults());
        }

        return "swapi_character";
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
        if (flag)
            log.info(nextWarrior.getName() + " was added to the " + nextWarrior.getOrder().getDesc() + " order");
        else log.error("no warrior to add");

        Warriors.printOrder(Warriors.getJedi());
        Warriors.printOrder(Warriors.getSith());

        return "redirect:/newWarrior";
    }


    @GetMapping("/test")
    public String toTest(Warrior warrior) {
        return "test";
    }


}
