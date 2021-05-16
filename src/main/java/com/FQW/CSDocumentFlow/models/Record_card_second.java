package com.FQW.CSDocumentFlow.models;

import javax.persistence.*;

@Entity
public class Record_card_second {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private String FIO, kind_of_work, discipline, faculty, student_group;
    private int number_of_students, number_of_hours;

    public Record_card_second() {
    }

    public Record_card_second(String FIO, String kind_of_work, String discipline, String faculty, String student_group, int number_of_students, int number_of_hours) {
        this.FIO = FIO;
        this.kind_of_work = kind_of_work;
        this.discipline = discipline;
        this.faculty = faculty;
        this.student_group = student_group;
        this.number_of_students = number_of_students;
        this.number_of_hours = number_of_hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getKind_of_work() {
        return kind_of_work;
    }

    public void setKind_of_work(String kind_of_work) {
        this.kind_of_work = kind_of_work;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getStudent_group() {
        return student_group;
    }

    public void setStudent_group(String student_group) {
        this.student_group = student_group;
    }

    public int getNumber_of_students() {
        return number_of_students;
    }

    public void setNumber_of_students(int number_of_students) {
        this.number_of_students = number_of_students;
    }

    public int getNumber_of_hours() {
        return number_of_hours;
    }

    public void setNumber_of_hours(int number_of_hours) {
        this.number_of_hours = number_of_hours;
    }
}
