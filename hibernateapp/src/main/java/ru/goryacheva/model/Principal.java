package ru.goryacheva.model;

import javax.persistence.*;

@Entity
@Table(name="Principal")
public class Principal {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @OneToOne(mappedBy = "principal")
    private School school;

    public Principal() {
    }

    public Principal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Principal(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
        school.setPrincipal(this);
    }

    @Override
    public String toString() {
        return "Principal: " + "id=" + id + ", name='" + name + '\'' + ", age=" + age;
    }

}
