package com.FQW.CSDocumentFlow.models;

import javax.persistence.*;

@Entity
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private String docName, docType;
    private String teacher, student_group, student, fqw_topic;

    @Lob
    private byte[] data;

    public Doc() {
    }

    public Doc(String docName, String docType, byte[] data, String teacher, String student_group, String student, String fqw_topic) {
        this.docName = docName;
        this.docType = docType;
        this.data = data;
        this.teacher = teacher;
        this.student_group = student_group;
        this.student = student;
        this.fqw_topic = fqw_topic;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent_group() {
        return student_group;
    }

    public void setStudent_group(String student_group) {
        this.student_group = student_group;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getFqw_topic() {
        return fqw_topic;
    }

    public void setFqw_topic(String fqw_topic) {
        this.fqw_topic = fqw_topic;
    }
}
