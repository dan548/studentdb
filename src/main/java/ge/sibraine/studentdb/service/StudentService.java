package ge.sibraine.studentdb.service;

import ge.sibraine.studentdb.dto.StudentDTO;
import ge.sibraine.studentdb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentConverter converter;
    private final StudentRepository repository;

    public StudentService(StudentConverter converter, StudentRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public void addStudent(StudentDTO student) {
        repository.save(converter.dtoToStudentEntity(student));
    }

    public List<StudentDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(converter::entityToStudentDTO)
                .toList();
    }

    public void deleteStudentByNumber(String studentNumber) {
        repository.deleteByStudentNumber(studentNumber);
    }

}
