package pl.rav.jediorder.support;

import pl.rav.jediorder.users.registration.UserForm;

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
        UserForm userForm = (UserForm) o;
        boolean isValid =  userForm.getPassword().equals(userForm.getPasswordConfirm());

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode( "passwordConfirm" ).addConstraintViolation();
        }

        return isValid;
    }


}
