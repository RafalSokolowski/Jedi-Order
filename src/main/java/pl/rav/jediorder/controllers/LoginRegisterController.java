package pl.rav.jediorder.controllers;

import lombok.extern.log4j.Log4j2;
import org.dom4j.rule.Mode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rav.jediorder.users.User;
import pl.rav.jediorder.users.UserRepo;
import pl.rav.jediorder.users.registration.UserForm;

import javax.validation.Valid;

@Log4j2
@Controller
public class LoginRegisterController {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public LoginRegisterController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
//        User defaultUser = new User("user", "user", "First Name", "Second Name", "30", "p.p@p", "500-500-500");
        User defaultUser = new User("user", passwordEncoder.encode("user"), null, null, null, null, null);
        userRepo.save(defaultUser);
        log.info("default user created and saved (login:user / password:user)");
    }

    @GetMapping("/login")
    public String login() {

//        User defaultUser = new User("user", passwordEncoder.encode("user"), null, null, null, null,null);
//        userRepo.save(defaultUser);
//        log.info("default user created and saved (login:user / password:user)");
        return "login";
    }

    @PostMapping("/login")
    public String logged(User user) {
//        log.info("Following user has just been logged: " + user.getUsername());
        return "/";
    }

    @GetMapping("/register_v2")
    public String registerForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register_v2";
    }

    @PostMapping("/register_v2")
    public String collectForm(@Valid @ModelAttribute UserForm userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userForm", userForm);
            return "register_v2";
        }
        User user = userForm.createUser(passwordEncoder);
        log.info("user created: " + user);
        model.addAttribute("newUsername", user.getUsername());
        userRepo.save(user);
//        return "redirect:/login";
        return "login";
    }
}
