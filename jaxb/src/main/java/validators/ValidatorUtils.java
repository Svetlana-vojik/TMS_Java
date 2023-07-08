package validators;

import exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {
    private void ValidatorUtils() {
    }
    public static void validateName(String name) throws ValidationException {
        Pattern patternName = Pattern.compile("[A-Z][a-z]+(\\s[A-Z][a-z]+){2}");
        Matcher matcher = patternName.matcher(name);
        if (!matcher.matches()) {
            throw new ValidationException("Tne name is not valid!");
        }
    }

    public static void validatePosition(String position) throws ValidationException {
        Pattern patternPosition = Pattern.compile("[A-Z][a-z\\s\\-]*");
        Matcher matcher = patternPosition.matcher(position);
        if (!matcher.matches()) {
            throw new ValidationException("Tne position is not valid!");
        }
    }

    public static void validateDepartment(String department) throws ValidationException {
        Pattern patternDepartment = Pattern.compile("[A-Za-z0-9\\s\\-]+");
        Matcher matcher = patternDepartment.matcher(department);
        if (!matcher.matches()) {
            throw new ValidationException("Tne departmenr is not valid!");
        }
    }

    public static void validateWorkExperience(String workExperience) throws ValidationException {
        Pattern patternWorkExperience = Pattern.compile("\\d+\\s(year)?(years)?");
        Matcher matcher = patternWorkExperience.matcher(workExperience);
        if (!matcher.matches()) {
            throw new ValidationException("Tne work experience is not valid!");
        }
    }
}