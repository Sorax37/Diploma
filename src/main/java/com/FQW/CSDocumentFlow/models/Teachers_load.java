package com.FQW.CSDocumentFlow.models;

import javax.persistence.*;

@Entity
public class Teachers_load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    private int number, specialty, semester, flow_number, group_number, student_number, discipline_code,
            lectures_one_flow, total_lectures, prac_works_one_flow, total_prac_works, lab_works_half_group,
            total_lab_works, consult_tek, consult_ex, exams, offsets, course_project, course_work, control_work,
            addit_lesson, indiv_one_group, total_indiv;
    private String lector, assistant, branch, discipline_name;


    public Teachers_load() {
    }

    public Teachers_load(int number, int specialty, int semester, int flow_number, int group_number, int student_number,
                         int discipline_code, int lectures_one_flow, int total_lectures, int prac_works_one_flow,
                         int total_prac_works, int lab_works_half_group, int total_lab_works, int consult_tek, int consult_ex,
                         int exams, int offsets, int course_project, int course_work, int control_work, int addit_lesson,
                         int indiv_one_group, int total_indiv, String lector, String assistant, String branch,
                         String discipline_name) {
        this.number = number;
        this.specialty = specialty;
        this.semester = semester;
        this.flow_number = flow_number;
        this.group_number = group_number;
        this.student_number = student_number;
        this.discipline_code = discipline_code;
        this.lectures_one_flow = lectures_one_flow;
        this.total_lectures = total_lectures;
        this.prac_works_one_flow = prac_works_one_flow;
        this.total_prac_works = total_prac_works;
        this.lab_works_half_group = lab_works_half_group;
        this.total_lab_works = total_lab_works;
        this.consult_tek = consult_tek;
        this.consult_ex = consult_ex;
        this.exams = exams;
        this.offsets = offsets;
        this.course_project = course_project;
        this.course_work = course_work;
        this.control_work = control_work;
        this.addit_lesson = addit_lesson;
        this.indiv_one_group = indiv_one_group;
        this.total_indiv = total_indiv;
        this.lector = lector;
        this.assistant = assistant;
        this.branch = branch;
        this.discipline_name = discipline_name;
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

    public int getSpecialty() {
        return specialty;
    }

    public void setSpecialty(int specialty) {
        this.specialty = specialty;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getFlow_number() {
        return flow_number;
    }

    public void setFlow_number(int flow_number) {
        this.flow_number = flow_number;
    }

    public int getGroup_number() {
        return group_number;
    }

    public void setGroup_number(int group_number) {
        this.group_number = group_number;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }

    public int getDiscipline_code() {
        return discipline_code;
    }

    public void setDiscipline_code(int discipline_code) {
        this.discipline_code = discipline_code;
    }

    public int getLectures_one_flow() {
        return lectures_one_flow;
    }

    public void setLectures_one_flow(int lectures_one_flow) {
        this.lectures_one_flow = lectures_one_flow;
    }

    public int getTotal_lectures() {
        return total_lectures;
    }

    public void setTotal_lectures(int total_lectures) {
        this.total_lectures = total_lectures;
    }

    public int getPrac_works_one_flow() {
        return prac_works_one_flow;
    }

    public void setPrac_works_one_flow(int prac_works_one_flow) {
        this.prac_works_one_flow = prac_works_one_flow;
    }

    public int getTotal_prac_works() {
        return total_prac_works;
    }

    public void setTotal_prac_works(int total_prac_works) {
        this.total_prac_works = total_prac_works;
    }

    public int getLab_works_half_group() {
        return lab_works_half_group;
    }

    public void setLab_works_half_group(int lab_works_half_group) {
        this.lab_works_half_group = lab_works_half_group;
    }

    public int getTotal_lab_works() {
        return total_lab_works;
    }

    public void setTotal_lab_works(int total_lab_works) {
        this.total_lab_works = total_lab_works;
    }

    public int getConsult_tek() {
        return consult_tek;
    }

    public void setConsult_tek(int consult_tek) {
        this.consult_tek = consult_tek;
    }

    public int getConsult_ex() {
        return consult_ex;
    }

    public void setConsult_ex(int consult_ex) {
        this.consult_ex = consult_ex;
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

    public int getCourse_project() {
        return course_project;
    }

    public void setCourse_project(int course_project) {
        this.course_project = course_project;
    }

    public int getCourse_work() {
        return course_work;
    }

    public void setCourse_work(int course_work) {
        this.course_work = course_work;
    }

    public int getControl_work() {
        return control_work;
    }

    public void setControl_work(int control_work) {
        this.control_work = control_work;
    }

    public int getAddit_lesson() {
        return addit_lesson;
    }

    public void setAddit_lesson(int addit_lesson) {
        this.addit_lesson = addit_lesson;
    }

    public int getIndiv_one_group() {
        return indiv_one_group;
    }

    public void setIndiv_one_group(int indiv_one_group) {
        this.indiv_one_group = indiv_one_group;
    }

    public int getTotal_indiv() {
        return total_indiv;
    }

    public void setTotal_indiv(int total_indiv) {
        this.total_indiv = total_indiv;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDiscipline_name() {
        return discipline_name;
    }

    public void setDiscipline_name(String discipline_name) {
        this.discipline_name = discipline_name;
    }
}
