package by.teachmeskills.homeworks.hw_28042023.SAX;

public class Doctor {
    private String name, position, department, workExperience;

    public Doctor(String name, String position, String department, String workExperience) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.workExperience = workExperience;
    }

    public Doctor() {

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", workExperience='" + workExperience + '\'' +
                '}';
    }
}