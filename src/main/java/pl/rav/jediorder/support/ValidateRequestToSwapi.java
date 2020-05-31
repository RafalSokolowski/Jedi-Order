package pl.rav.jediorder.support;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotEmpty()
@Min(value = 1)
@Max(value = 83)
@Pattern(regexp = "[0-9]*")

@Target({ METHOD, FIELD, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
@Documented

@ReportAsSingleViolation
public @interface ValidateRequestToSwapi {

        String message() default "Only numbers between 1 and 83 are allowed here";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };

}
