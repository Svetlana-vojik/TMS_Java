import exceptions.ValidationException;
import validators.ValidatorUtils;

public class CheckValidation {
    public static void main(String[] args) {
        try {
            ValidatorUtils.validateName("Petrova Svetlava Igorevna");
            ValidatorUtils.validatePosition("Dentist");
            ValidatorUtils.validateDepartment("Dental");
            ValidatorUtils.validateWorkExperience("1 years");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}