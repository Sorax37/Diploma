package com.FQW.CSDocumentFlow.models;

import javax.persistence.*;

@Entity
public class StaffingTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private String teacher, position;
    private float rate;
    private int norm, plan;

    public StaffingTable() {
    }

    public StaffingTable(String teacher, String position, float rate, int norm, int plan) {
        this.teacher = teacher;
        this.position = position;
        this.rate = rate;
        this.norm = norm;
        this.plan = plan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getNorm() {
        return norm;
    }

    public void setNorm(int norm) {
        this.norm = norm;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }
}
