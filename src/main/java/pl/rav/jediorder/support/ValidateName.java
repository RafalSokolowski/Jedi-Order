package pl.rav.jediorder.support;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.*;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull()
@NotEmpty()
@Size(min=3, max=20)

@Target({ METHOD, FIELD, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
@Documented

@ReportAsSingleViolation
public @interface ValidateName {

        String message() default "Field cannot be empty and must have 3-20 characters";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };

}
