package cl.usach.ayudantia1.services;

import cl.usach.ayudantia1.models.Subject;
import cl.usach.ayudantia1.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subjects")
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Subject> getAllSubjects()
    {
        return subjectRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    public Subject getSubject(@PathVariable Long id)
    {
        return subjectRepository.findSubjectById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseBody
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id)
    {
        Subject subject = subjectRepository.findSubjectById(id);
        if(subject == null)
            return new ResponseEntity<Subject>(subject, HttpStatus.NOT_FOUND);
        subjectRepository.delete(subject);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Subject createSubject(@RequestBody Subject subject)
    {
        return subjectRepository.save(subject);
    }
}
