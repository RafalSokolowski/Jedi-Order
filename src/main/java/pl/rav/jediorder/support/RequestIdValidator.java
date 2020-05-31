package pl.rav.jediorder.support;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RequestIdValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return RequestToSwapiID.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        RequestToSwapiID requestToSwapi;
        if (object instanceof RequestToSwapiID) {
            requestToSwapi = (RequestToSwapiID) object;
            if (requestToSwapi.getRequestID() == null) errors.rejectValue("null", "requestID equals null");
            if (requestToSwapi.getRequestID().isEmpty()) errors.rejectValue("empty", "requestID is empty");
            if (requestToSwapi.getRequestID().equalsIgnoreCase("dupa")) errors.rejectValue("un polite", "un polite word usage");
        } else {
            errors.rejectValue("object mismatch", "wrong usage of customised validator");
        }

    }
}
