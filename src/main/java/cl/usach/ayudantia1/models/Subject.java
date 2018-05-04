package cl.usach.ayudantia1.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {
    // Atributtes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Long id;

    private String name;

    private int level;

    private String code;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    // Constructors
    public Subject() {
    }

    public Subject(String name, int level, String code) {
        this.name = name;
        this.level = level;
        this.code = code;
    }

    // Methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
