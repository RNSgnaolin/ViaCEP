package cepapi.service.validation;

import java.util.regex.Pattern;

public class ValidateCep implements ValidationService {

    private String regex = "^\\d{5}\\-\\d{3}$|\\d{8}$";

    public boolean validate(String query) {
        return Pattern.matches(regex, query);
    }
    
}
