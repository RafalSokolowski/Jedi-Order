package pl.rav.jediorder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import pl.rav.jediorder.users.User;
import pl.rav.jediorder.users.login.AppAuthenticationFailureHandler;


// in-memory authentication with 2 users (classic user and admin)

@Configuration
@EnableWebSecurity

public class PortalAccess extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
//        authentication.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("user")).authorities("ROLE_USER");
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN");
        authentication
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/background/*", "/css/*", "/images/*", "/font/StarWarsFont/*", "/sounds/*", "/error/*", "/login*", "/error", "/register", "/register_v2").permitAll()
                .anyRequest()
                .authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .failureHandler(AppAuthenticationFailureHandler())
                .failureUrl("/login-error")
//                .failureUrl("/login")
//                .failureUrl("/login?error=true")
//                .failureForwardUrl("/login")

                .and()
                .logout()
                .logoutSuccessUrl("/");

//                .and()
//                .httpBasic();     // browser auto pop-up for login :)

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler AppAuthenticationFailureHandler() {
        return new AppAuthenticationFailureHandler();
    }

}
