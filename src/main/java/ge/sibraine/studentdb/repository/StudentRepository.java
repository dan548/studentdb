package ge.sibraine.studentdb.repository;

import ge.sibraine.studentdb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

    void deleteByStudentNumber(String studentNumber);

}
