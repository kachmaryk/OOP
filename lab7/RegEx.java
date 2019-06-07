package lab7;

import java.util.regex.Pattern;

public class RegEx {

    public static boolean isValidProduct(String name) {
        Pattern patternName = Pattern.compile("\\D");
        return patternName.matcher(name).find();
    }
    public static boolean isValidUnitOfMeasurement(String name) {
        Pattern patternName = Pattern.compile("\\D");
        return patternName.matcher(name).find();
    }
    public static boolean isValidAmount(String name) {
        Pattern patternName = Pattern.compile("\\d");
        return patternName.matcher(name).find();
    }
    public static boolean isValidPriceOfProduct(String name) {
        Pattern patternName = Pattern.compile("\\d");
        return patternName.matcher(name).find();
    }
    public static boolean isValidWeight(String name) {
        Pattern patternName = Pattern.compile("\\d");
        return patternName.matcher(name).find();
    }
    public static boolean isValidDateOfArriving(String dateOfArriving) {
        Pattern patternDateOfConviction = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");
        return patternDateOfConviction.matcher(dateOfArriving).find();
    }

}