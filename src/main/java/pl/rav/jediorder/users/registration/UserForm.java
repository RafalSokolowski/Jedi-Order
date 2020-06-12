package pl.rav.jediorder.users.registration;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.rav.jediorder.support.PasswordMatch;
import pl.rav.jediorder.support.ValidateUserString;
import pl.rav.jediorder.users.User;

import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@PasswordMatch
public class UserForm {

    @ValidateUserString
    private String username;

//    @Pattern(regexp="^(.{0,5}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$", message = "at least: 6 signs, one LC letter, one UC letter and one special sign")
    @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$", message = "at least: 6 signs, one letter, one number and one special sign")
    private String password;
    private String passwordConfirm;


    @Pattern(regexp="^$|.{3,20}", message = "if filled, must have 3-20 characters")
    private String firstName;

    @Pattern(regexp="^$|.{3,20}", message = "if filled, must have 3-20 characters")
    private String secondName;

    @Pattern(regexp = "1[2-9]|[2-9][0-9]", message = "Apologise, but minimum age for the platform is 12 and maximum 99")
    private String age;

    @NotEmpty (message = "email is mandatory")
    @Email(message = "unappropriated email format")
    private String email;


    @Pattern(regexp = "^$|[0-9]{3}-[0-9]{3}-[0-9]{3}", message = "please use XXX-XXX-XXX format, digits only")
    private String phone;

    public User createUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), firstName, secondName, age, email, phone, false);
    }

}
