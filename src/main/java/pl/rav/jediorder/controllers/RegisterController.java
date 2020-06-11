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
@RequestMapping("/register_v2")
public class RegisterController {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register_v2";
    }

    @PostMapping
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
