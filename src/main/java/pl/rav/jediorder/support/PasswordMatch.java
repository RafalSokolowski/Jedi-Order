package pl.rav.jediorder.support;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordsValidator.class)
@Documented
public @interface PasswordMatch {
    String message() default "Make sure to correctly repeat your password!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
