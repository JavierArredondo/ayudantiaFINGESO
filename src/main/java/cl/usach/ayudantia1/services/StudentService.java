package cl.usach.ayudantia1.services;

import cl.usach.ayudantia1.models.Student;
import cl.usach.ayudantia1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentService {
    /*
    Autowired sirve para inyectar StudentRepository a la clase StudentService, evita instanciar el repositorio.
    */
    @Autowired
    private StudentRepository studentRepository;

    /* Recordar operaciones CRUD -> verbos HTTP
    Create -> POST
    Read   -> GET
    Update -> PUT
    Delete -> DELETE
     */

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable Long id)
    {
        return studentRepository.findStudentById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id)
    {
        Student student = studentRepository.findStudentById(id);
        if(student == null)
            return new ResponseEntity<Student>(student, HttpStatus.NOT_FOUND);
        studentRepository.delete(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
}
