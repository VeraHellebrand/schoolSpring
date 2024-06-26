package cz.vh.controller;

import cz.vh.dto.StudentDto;
import cz.vh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping({"/students","/students/"})
    public List<StudentDto> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping({"/students","/students/"})
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }
    @GetMapping({"/students/{id}","/students/{id}/"})
    public StudentDto getStudent(@PathVariable("id") Integer id){
        return studentService.getStudent(id);
    }
    @PutMapping({"/students/{id}","/students/{id}/"})
    public StudentDto editStudent(@PathVariable("id") Integer id, @RequestBody StudentDto studentDto){
        return studentService.editStudent(id, studentDto);
    }

    @DeleteMapping({"/students/{id}","/students/{id}/"})
    public StudentDto deleteStudent(@PathVariable("id") Integer id){
        return studentService.deleteStudent(id);
    }



}
