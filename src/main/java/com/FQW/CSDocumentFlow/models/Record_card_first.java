package com.FQW.CSDocumentFlow.models;

import javax.persistence.*;

@Entity
public class Record_card_first {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private String FIO, discipline, lesson_type, student_group, date;
    private int number_of_hours;
    private boolean activity;

    public Record_card_first() {
    }

    public Record_card_first(String FIO, String discipline, String lesson_type, String student_group, String date, int number_of_hours) {
        this.FIO = FIO;
        this.discipline = discipline;
        this.lesson_type = lesson_type;
        this.student_group = student_group;
        this.date = date;
        this.number_of_hours = number_of_hours;
        this.activity = true;
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

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getLesson_type() {
        return lesson_type;
    }

    public void setLesson_type(String lesson_type) {
        this.lesson_type = lesson_type;
    }

    public String getStudent_group() {
        return student_group;
    }

    public void setStudent_group(String student_group) {
        this.student_group = student_group;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public int getNumber_of_hours() {
        return number_of_hours;
    }

    public void setNumber_of_hours(int number_of_hours) {
        this.number_of_hours = number_of_hours;
    }
}
