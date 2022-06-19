package ge.sibraine.studentdb.service;

import ge.sibraine.studentdb.dto.StudentDTO;
import ge.sibraine.studentdb.entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class StudentConverter {

    public StudentDTO entityToStudentDTO(Student student) {
        var dto = new StudentDTO();
        dto.setLastName(student.getLastName());
        dto.setFirstName(student.getFirstName());
        dto.setPatronymic(student.getPatronymic());
        dto.setBirthDate(student.getBirthDate());
        dto.setGroup(student.getGroupNumber());
        dto.setStudentNumber(student.getStudentNumber());
        return dto;
    }

    public Student dtoToStudentEntity(StudentDTO studentDTO) {
        var entity = new Student();
        entity.setLastName(studentDTO.getLastName());
        entity.setFirstName(studentDTO.getFirstName());
        entity.setPatronymic(studentDTO.getPatronymic());
        entity.setBirthDate(studentDTO.getBirthDate());
        entity.setGroupNumber(studentDTO.getGroup());
        entity.setStudentNumber(studentDTO.getStudentNumber());
        entity.setId(String.valueOf(UUID.randomUUID()));
        return entity;
    }

}
