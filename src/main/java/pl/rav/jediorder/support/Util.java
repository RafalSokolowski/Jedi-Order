package pl.rav.jediorder.support;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Util {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static boolean isStringParsableToNumberAndInRange(String string, int left, int right) {
        if (string == null) return false;

        try {
            int i = Integer.parseInt(string);
            return (i <= right && i >= left);
        } catch (NumberFormatException e) {
//            log.error("The number was expected, this is not a number: " + string);
            return false;
        }

    }

}
