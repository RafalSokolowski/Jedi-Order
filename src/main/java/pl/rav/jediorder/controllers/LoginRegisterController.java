package pl.rav.jediorder.controllers;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.dom4j.rule.Mode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rav.jediorder.users.LoginAttempt;
import pl.rav.jediorder.users.User;
import pl.rav.jediorder.users.UserRepo;
import pl.rav.jediorder.users.registration.UserForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLOutput;

@Log4j2
@Controller
public class LoginRegisterController {

    @Getter
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public LoginRegisterController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

        User admin = new User(
                "Admin",
                passwordEncoder.encode("Admin"),
                "Mr.",
                "Administrator",
                "42",
                "admin@admin.pl",
                "500-500-500",
                true);
        User defaultUser1 = new User(
                "User",
                passwordEncoder.encode("User"),
                "Standard",
                "Userczyk",
                "20",
                "user@user.us",
                null,
                false);

        User defaultUser2 = new User(
                "Test",
                passwordEncoder.encode("Test"),
                "Sample",
                "Enabled",
                "13",
                "user2@user.us",
                null,
                false);

        defaultUser2.setOn(false);

        this.userRepo.save(defaultUser1);
        this.userRepo.save(defaultUser2);
        this.userRepo.save(admin);
//        log.error(admin);
        log.info("Default user created and saved (login:user / password:user)");
        log.info("Administrator account was created and saved with externally difficult and secret password:)");

    }


    @GetMapping("/login")
    public String login(Model model) {

//        User defaultUser = new User("user", passwordEncoder.encode("user"), null, null, null, null,null);
//        userRepo.save(defaultUser);
//        log.info("default user created and saved (login:user / password:user)");

        model.addAttribute("loginAttempt", new LoginAttempt());

        return "login";
    }

    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        if ("User is disabled".equalsIgnoreCase(errorMessage)) errorMessage = "ERROR: Account is disabled. Contact your Administrator";
        else if ("Bad credentials".equalsIgnoreCase(errorMessage)) errorMessage = "ERROR: Invalid credentials";
        else errorMessage = "ERROR: Invalid data";
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

//    @PostMapping("/login")
//    public String logged(LoginAttempt loginAttempt) {
//        log.info("login PostMapping " + loginAttempt);
//        return "index";
//    }

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
