package pl.rav.jediorder.support;

import pl.rav.jediorder.users.NewUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValidator implements ConstraintValidator<PasswordMatch, Object> {

    private String message;

    @Override
    public void initialize(PasswordMatch passwordMatch) {
        this.message = passwordMatch.message();
    }
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context){
        NewUser user = (NewUser) o;
        boolean isValid =  user.getPassword().equals(user.getMatchingPassword());

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode( "matchingPassword" ).addConstraintViolation();
        }

        return isValid;
    }


}
