package ge.sibraine.studentdb.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Objects;

public class StudentDTO {

    @NotBlank(message = "Last name can not be blank!!!")
    private String lastName;
    @NotBlank(message = "First name can not be blank!!!")
    private String firstName;
    private String patronymic;
    @NotNull(message = "Please enter birth date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private String birthDate;

    @NotBlank(message = "Group number can not be blank!!!")
    private String group;

    @NotBlank(message = "Unique number can not be blank!!!")
    private String studentNumber;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO that = (StudentDTO) o;
        return Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(patronymic, that.patronymic) && Objects.equals(birthDate, that.birthDate) && Objects.equals(group, that.group) && Objects.equals(studentNumber, that.studentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, birthDate, group, studentNumber);
    }
}
