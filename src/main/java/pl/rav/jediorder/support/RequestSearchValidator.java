package pl.rav.jediorder.support;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RequestSearchValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return RequestToSwapiSEARCH.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        RequestToSwapiSEARCH requestToSwapiSEARCH;
        if (object instanceof RequestToSwapiSEARCH) {
            requestToSwapiSEARCH = (RequestToSwapiSEARCH) object;
            if (requestToSwapiSEARCH.getRequestSEARCH() == null) errors.rejectValue("null", "requestSEARCH equals null");
            if (requestToSwapiSEARCH.getRequestSEARCH().isEmpty()) errors.rejectValue("empty", "requestSEARCH is empty");
            if (requestToSwapiSEARCH.getRequestSEARCH().equalsIgnoreCase("dupa")) errors.rejectValue("un polite", "un polite word usage");
        } else {
            errors.rejectValue("object mismatch", "wrong usage of customised validator");
        }

    }
}
