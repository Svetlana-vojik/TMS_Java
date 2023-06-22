package by.teachmeskills.homeworks.hw_28042023.SAX;

public class Doctor {
    private String name, position, department, workExperience;

    public Doctor(String name, String position, String department, String workExperience) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.workExperience = workExperience;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getWorkExperience() {
        return workExperience;
    }
}