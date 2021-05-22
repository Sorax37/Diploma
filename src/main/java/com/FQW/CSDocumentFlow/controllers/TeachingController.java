package com.FQW.CSDocumentFlow.controllers;

import com.FQW.CSDocumentFlow.models.*;
import com.FQW.CSDocumentFlow.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeachingController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private Record_card_firstRepository rec_card_first_Repository;

    @Autowired
    private Record_card_secondRepository rec_card_second_Repository;

    @Autowired
    private App_UserRepository app_userRepository;

    @Autowired
    private StaffingTableRepository staffingTableRepository;

    @Autowired
    private DisciplinesRepository disciplinesRepository;

    @Autowired
    private Teachers_loadRepository teachersloadRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teaching")
    public String teaching(Model model, App_User user) {
        App_User app_user = app_userRepository.findByFIO(user.getFIO());
        model.addAttribute("app_user", app_user);
        return "teaching-main";
    }

    @GetMapping("/teaching/schedule")
    public String teaching_schedule(Model model) {
        Iterable<Schedule> schedules = scheduleRepository.findAll();
        model.addAttribute("schedules", schedules);
        return "teaching-schedule";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/schedule/update")
    public String teaching_schedule_update(Model model) { return "teaching-schedule_update";}

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teaching/schedule/update")
    public String schedule_new_update(@RequestParam String day_of_the_week, @RequestParam String period, @RequestParam String student_group, @RequestParam String discipline, @RequestParam String audience, @RequestParam String teacher, Model model) {
        Schedule schedule = new Schedule(day_of_the_week, period, student_group, discipline, audience, teacher);
        scheduleRepository.save(schedule);
        return "redirect:/teaching/schedule";
    }

    @GetMapping("/teaching/record_card/update")
    public String teaching_record_card_update(Model model) {
        return "teaching-card_update";
    }

    @PostMapping("/teaching/card_first/update")
    public String card_new_update_first(@RequestParam String discipline, @RequestParam String lesson_type, @RequestParam String student_group, @RequestParam String date, @RequestParam int number_of_hours, Model model) {
        App_User app_user = (App_User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usfio = app_user.getFIO();
        model.addAttribute("usfio", usfio);
        Record_card_first record_card_first = new Record_card_first(usfio, discipline, lesson_type, student_group, date, number_of_hours);
        rec_card_first_Repository.save(record_card_first);
        return "redirect:/teaching/record_card";
    }

    @PostMapping("/teaching/card_second/update")
    public String card_new_update_second(@RequestParam String kind_of_work, @RequestParam String discipline, @RequestParam String faculty, @RequestParam String student_group, @RequestParam int number_of_students, @RequestParam int number_of_hours, Model model) {
        App_User app_user = (App_User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usfio = app_user.getFIO();
        model.addAttribute("usfio", usfio);
        Record_card_second record_card_second = new Record_card_second(usfio, kind_of_work, discipline, faculty, student_group, number_of_students, number_of_hours);
        rec_card_second_Repository.save(record_card_second);
        return "redirect:/teaching/record_card";
    }

    @GetMapping("/teaching/record_card")
    public String teaching_record_table(Model model) {
        App_User app_user = (App_User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usfio = app_user.getFIO();
        model.addAttribute("usfio", usfio);
        List<Record_card_first> first_card_data =  rec_card_first_Repository.findByFIO(usfio);
        model.addAttribute("first_card_data", first_card_data);
        List<Record_card_second> second_card_data =  rec_card_second_Repository.findByFIO(usfio);
        model.addAttribute("second_card_data", second_card_data);
        return "teaching-record_card";
    }


    @GetMapping("/teaching/record_cards_show")
    public String show_record_cards(Model model) {
        List<App_User> teachers = app_userRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teaching-record_card_all";
    }

    @PostMapping("/teaching/record_cards_show")
    public String record_card_search(@RequestParam String teacherFIO, Model model) {
        List<App_User> teachers = app_userRepository.findAll();
        model.addAttribute("teachers", teachers);
        List<Record_card_first> first_card_data =  rec_card_first_Repository.findByFIO(teacherFIO);
        model.addAttribute("first_card_data", first_card_data);
        List<Record_card_second> second_card_data =  rec_card_second_Repository.findByFIO(teacherFIO);
        model.addAttribute("second_card_data", second_card_data);
        return "teaching-record_card_all";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/staffing_table")
    public String staffing_table(Model model) {
        Iterable<StaffingTable> staffingTableData = staffingTableRepository.findAll();
        model.addAttribute("staffingTableData", staffingTableData);
        return "teaching-staffing-table";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/staffing_table/update")
    public String staffing_table_update(Model model) {
        return "teaching-staffing-table_update";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teaching/staffing_table/update")
    public String staffing_table_new_update(@RequestParam String teacher, @RequestParam String position, @RequestParam float rate, @RequestParam int norm, @RequestParam int plan, Model model) {
        StaffingTable staftable = new StaffingTable(teacher, position, rate, norm, plan);
        staffingTableRepository.save(staftable);
        return "redirect:/teaching/staffing_table";
    }

    @GetMapping("/teaching/disciplines")
    public String disciplines(Model model) {
        Iterable<Discipline> disciplinesData = disciplinesRepository.findAll();
        model.addAttribute("disciplinesData", disciplinesData);
        return "teaching-disciplines";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/disciplines/update")
    public String disciplines_update(Model model) {
        return "teaching-disciplines_update";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teaching/disciplines/update")
    public String disciplines_new_update(@RequestParam int number, @RequestParam int code, @RequestParam String abbreviation, @RequestParam String name, Model model) {
        Discipline discipline = new Discipline(number, code, abbreviation, name);
        disciplinesRepository.save(discipline);
        return "redirect:/teaching/disciplines";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/load")
    public String load(Model model) {
        Iterable<Teachers_load> loadData = teachersloadRepository.findAll();
        model.addAttribute("loadData", loadData);
        return "teaching-load";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/load/update")
    public String load_update(Model model) {
        return "teaching-load_update";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teaching/load/update")
    public String load_new_update(@RequestParam int number, @RequestParam int specialty, @RequestParam int semester,
                                  @RequestParam int flow_number, @RequestParam int group_number, @RequestParam int student_number,
                                  @RequestParam int discipline_code, @RequestParam int lectures_one_flow,
                                  @RequestParam int total_lectures, @RequestParam int prac_works_one_flow,
                                  @RequestParam int total_prac_works, @RequestParam int lab_works_half_group,
                                  @RequestParam int total_lab_works, @RequestParam int consult_tek, @RequestParam int consult_ex,
                                  @RequestParam int exams, @RequestParam int offsets, @RequestParam int course_project,
                                  @RequestParam int course_work, @RequestParam int control_work, @RequestParam int addit_lesson,
                                  @RequestParam int indiv_one_group, @RequestParam int total_indiv, @RequestParam String lector,
                                  @RequestParam String assistant, @RequestParam String branch, @RequestParam String discipline_name,
                                  Model model) {
        Teachers_load teachersload = new Teachers_load(number, specialty, semester, flow_number, group_number, student_number, discipline_code,
                lectures_one_flow, total_lectures, prac_works_one_flow, total_prac_works, lab_works_half_group,
                total_lab_works, consult_tek, consult_ex, exams, offsets, course_project, course_work, control_work,
                addit_lesson, indiv_one_group, total_indiv, lector, assistant, branch, discipline_name);
        teachersloadRepository.save(teachersload);
        return "redirect:/teaching/load";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/teachers")
    public String teachers(Model model) {
        Iterable<Teacher> teacherData = teacherRepository.findAll();
        model.addAttribute("teacherData", teacherData);
        return "teaching-teachers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/teachers/update")
    public String teachers_update(Model model) {
        return "teaching-teachers_update";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teaching/teachers/update")
    public String teachers_new_update(@RequestParam int number, @RequestParam int plan, @RequestParam int teacher_load,
                                      @RequestParam int total, @RequestParam int lectures, @RequestParam int practic_works,
                                      @RequestParam int lab_works, @RequestParam int tek_consult, @RequestParam int ex_consult,
                                      @RequestParam int exams, @RequestParam int offsets, @RequestParam int KP,
                                      @RequestParam int KR, @RequestParam int control_works, @RequestParam int addit,
                                      @RequestParam int leader_graduate, @RequestParam int entering_graduate,
                                      @RequestParam int practic, @RequestParam int FQW_bachelors, @RequestParam int check_FQW,
                                      @RequestParam int leader_mag_first, @RequestParam int leader_mag_second,
                                      @RequestParam String FIO, @RequestParam float rate, @RequestParam float remainder,
                                      @RequestParam float comiss_bac, @RequestParam float comiss_mag, Model model) {
        Teacher teacher = new Teacher(number, plan, teacher_load, total, lectures, practic_works, lab_works, tek_consult,
                ex_consult, exams, offsets, KP, KR, control_works, addit, leader_graduate, entering_graduate, practic,
                FQW_bachelors, check_FQW, leader_mag_first, leader_mag_second, FIO, rate, remainder, comiss_bac, comiss_mag);
        teacherRepository.save(teacher);
        return "redirect:/teaching/teachers";
    }
}