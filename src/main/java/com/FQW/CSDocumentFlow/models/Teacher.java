package com.FQW.CSDocumentFlow.models;

import javax.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private int number, plan, teacher_load, total, lectures, practic_works, lab_works, tek_consult, ex_consult, exams,
            offsets, KP, KR, control_works, addit, leader_graduate, entering_graduate, practic, FQW_bachelors, check_FQW,
            leader_mag_first, leader_mag_second;
    private String FIO;
    private float rate, remainder, comiss_bac, comiss_mag;

    public Teacher() {
    }

    public Teacher(int number, int plan, int teacher_load, int total, int lectures, int practic_works, int lab_works,
                   int tek_consult, int ex_consult, int exams, int offsets, int KP, int KR, int control_works, int addit,
                   int leader_graduate, int entering_graduate, int practic, int FQW_bachelors, int check_FQW,
                   int leader_mag_first, int leader_mag_second, String FIO, float rate, float remainder, float comiss_bac,
                   float comiss_mag) {
        this.number = number;
        this.plan = plan;
        this.teacher_load = teacher_load;
        this.total = total;
        this.lectures = lectures;
        this.practic_works = practic_works;
        this.lab_works = lab_works;
        this.tek_consult = tek_consult;
        this.ex_consult = ex_consult;
        this.exams = exams;
        this.offsets = offsets;
        this.KP = KP;
        this.KR = KR;
        this.control_works = control_works;
        this.addit = addit;
        this.leader_graduate = leader_graduate;
        this.entering_graduate = entering_graduate;
        this.practic = practic;
        this.FQW_bachelors = FQW_bachelors;
        this.check_FQW = check_FQW;
        this.leader_mag_first = leader_mag_first;
        this.leader_mag_second = leader_mag_second;
        this.FIO = FIO;
        this.rate = rate;
        this.remainder = remainder;
        this.comiss_bac = comiss_bac;
        this.comiss_mag = comiss_mag;
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

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getTeacher_load() {
        return teacher_load;
    }

    public void setTeacher_load(int teacher_load) {
        this.teacher_load = teacher_load;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLectures() {
        return lectures;
    }

    public void setLectures(int lectures) {
        this.lectures = lectures;
    }

    public int getPractic_works() {
        return practic_works;
    }

    public void setPractic_works(int practic_works) {
        this.practic_works = practic_works;
    }

    public int getLab_works() {
        return lab_works;
    }

    public void setLab_works(int lab_works) {
        this.lab_works = lab_works;
    }

    public int getTek_consult() {
        return tek_consult;
    }

    public void setTek_consult(int tek_consult) {
        this.tek_consult = tek_consult;
    }

    public int getEx_consult() {
        return ex_consult;
    }

    public void setEx_consult(int ex_consult) {
        this.ex_consult = ex_consult;
    }

    public int getExams() {
        return exams;
    }

    public void setExams(int exams) {
        this.exams = exams;
    }

    public int getOffsets() {
        return offsets;
    }

    public void setOffsets(int offsets) {
        this.offsets = offsets;
    }

    public int getKP() {
        return KP;
    }

    public void setKP(int KP) {
        this.KP = KP;
    }

    public int getKR() {
        return KR;
    }

    public void setKR(int KR) {
        this.KR = KR;
    }

    public int getControl_works() {
        return control_works;
    }

    public void setControl_works(int control_works) {
        this.control_works = control_works;
    }

    public int getAddit() {
        return addit;
    }

    public void setAddit(int addit) {
        this.addit = addit;
    }

    public int getLeader_graduate() {
        return leader_graduate;
    }

    public void setLeader_graduate(int leader_graduate) {
        this.leader_graduate = leader_graduate;
    }

    public int getEntering_graduate() {
        return entering_graduate;
    }

    public void setEntering_graduate(int entering_graduate) {
        this.entering_graduate = entering_graduate;
    }

    public int getPractic() {
        return practic;
    }

    public void setPractic(int practic) {
        this.practic = practic;
    }

    public int getFQW_bachelors() {
        return FQW_bachelors;
    }

    public void setFQW_bachelors(int FQW_bachelors) {
        this.FQW_bachelors = FQW_bachelors;
    }

    public int getCheck_FQW() {
        return check_FQW;
    }

    public void setCheck_FQW(int check_FQW) {
        this.check_FQW = check_FQW;
    }

    public int getLeader_mag_first() {
        return leader_mag_first;
    }

    public void setLeader_mag_first(int leader_mag_first) {
        this.leader_mag_first = leader_mag_first;
    }

    public int getLeader_mag_second() {
        return leader_mag_second;
    }

    public void setLeader_mag_second(int leader_mag_second) {
        this.leader_mag_second = leader_mag_second;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getRemainder() {
        return remainder;
    }

    public void setRemainder(float remainder) {
        this.remainder = remainder;
    }

    public float getComiss_bac() {
        return comiss_bac;
    }

    public void setComiss_bac(float comiss_bac) {
        this.comiss_bac = comiss_bac;
    }

    public float getComiss_mag() {
        return comiss_mag;
    }

    public void setComiss_mag(float comiss_mag) {
        this.comiss_mag = comiss_mag;
    }
}
