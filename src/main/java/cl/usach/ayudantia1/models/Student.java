package cl.usach.ayudantia1.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    // Atributtes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    private String name;

    private String last_name;

    private int age;

    private String rut;

    @ManyToMany
    @JoinTable(name="student_subjects",joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    // Constructors
    public Student() {
    }

    public Student(String name, String last_name, int age, String rut) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.rut = rut;
    }

    public Student(String name, String last_name, int age, String rut, List<Subject> subjects) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.rut = rut;
        this.subjects = subjects;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}

