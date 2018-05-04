package cl.usach.ayudantia1.repositories;

import cl.usach.ayudantia1.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public Subject findSubjectById(Long id);
}
