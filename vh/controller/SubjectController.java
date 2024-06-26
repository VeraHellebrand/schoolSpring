package cz.vh.controller;

import cz.vh.dto.SubjectDto;
import cz.vh.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping({"/subjects","/subjects/"})
    public List<SubjectDto> getSubjects(){
        return subjectService.getSubjects();
    }
    @PostMapping({"/subjects","/subjects/"})
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }
    @GetMapping({"/subjects/{id}","/subjects/{id}/"})
    public SubjectDto getSubject(@PathVariable("id") Integer id){
        return subjectService.getSubject(id);
    }
    @PutMapping({"/subjects/{id}","/subjects/{id}/"})
    public SubjectDto editSubject(@PathVariable("id") Integer id, @RequestBody SubjectDto subjectDto){
        return subjectService.editSubject(id, subjectDto);
    }

    @DeleteMapping({"/subjects/{id}","/subjects/{id}/"})
    public SubjectDto deleteSubject(@PathVariable("id") Integer id){
        return subjectService.deleteSubject(id);
    }
}
