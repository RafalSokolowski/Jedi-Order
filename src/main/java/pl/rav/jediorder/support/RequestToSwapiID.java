package pl.rav.jediorder.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class RequestToSwapiID {

//    @NotEmpty(message = "request cannot be empty")
//    @Min(value = 1, message = "request needs to be greater than or equal to 1")
//    @Max(value = 83, message = "request needs to be lower than or equal to 83")
//    @Pattern(regexp = "[0-9]*", message = "Only numbers are allowed")

    @ValidateRequestToSwapi
    private String requestID;
}
