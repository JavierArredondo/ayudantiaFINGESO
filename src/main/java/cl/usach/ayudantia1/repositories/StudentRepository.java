package cl.usach.ayudantia1.repositories;

import cl.usach.ayudantia1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findStudentById(Long id);
}
