package com.FQW.CSDocumentFlow.models;

import javax.persistence.*;

@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private int number, code;
    private String abbreviation, name;

    public Discipline() {
    }

    public Discipline(int number, int code, String abbreviation, String name) {
        this.number = number;
        this.code = code;
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
