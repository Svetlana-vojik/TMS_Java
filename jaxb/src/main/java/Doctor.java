import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Doctor {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "department")
    private String department;
    @XmlElement(name = "workExperience")
    private String workExperience;

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