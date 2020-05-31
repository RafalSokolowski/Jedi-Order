package pl.rav.jediorder.users;

import lombok.*;
import pl.rav.jediorder.support.PasswordMatch;
import pl.rav.jediorder.support.ValidateName;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@PasswordMatch
public class NewUser {

    //    @NotNull(message = "first name cannot be null")
//    @NotEmpty(message = "first name cannot be empty")
//    @Size(min=3, max=20, message = "first name must be between 3 and 40 characters")
    @ValidateName
    private String firstName;

    //    @NotNull(message = "last name cannot be null")
//    @NotEmpty(message = "last name cannot be empty")
//    @Size(min=3, max=40, message = "last name must be between 3 and 40 characters")
    @ValidateName
    private String lastName;

    @Min(value = 12, message = "Age should not be less than 12")
    private int age;

    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    private String matchingPassword;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

//    public void setMatchingPassword(String matchingPassword) {
//        if (matchingPassword.equals(this.password))
//            this.matchingPassword = matchingPassword;
//        throw new IllegalArgumentException("Passwords not matched!");
//    }
}
