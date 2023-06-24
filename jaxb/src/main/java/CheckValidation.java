import exceptions.ValidationException;
import validators.validatorUtils;

public class CheckValidation {
    public static void main(String[] args) {
        try {
            validatorUtils.validateName("Petrova Svetlava Igorevna");
            validatorUtils.validatePosition("Dentist");
            validatorUtils.validateDepartment("Dental");
            validatorUtils.validateWorkExperience("1 years");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}