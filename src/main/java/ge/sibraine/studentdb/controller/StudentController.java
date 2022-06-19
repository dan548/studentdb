package ge.sibraine.studentdb.controller;

import ge.sibraine.studentdb.dto.StudentDTO;
import ge.sibraine.studentdb.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/showAllStudents")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "showAllStudents";
    }

    @GetMapping("/addStudent")
    public String showAddStudentPage(Model model) {
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("studentDTO", studentDTO);

        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String saveStudent(@Valid StudentDTO studentDTO, Errors errors, Model model) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "addStudent";
        }
        studentService.addStudent(studentDTO);
        return "redirect:/showAllStudents";
    }

    @GetMapping("/deleteStudent/{number}")
    public String deleteViaNumber(@PathVariable String number) {
        studentService.deleteStudentByNumber(number);
        return "redirect:/showAllStudents";
    }
}
