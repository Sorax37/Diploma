package com.FQW.CSDocumentFlow.controllers;

import com.FQW.CSDocumentFlow.models.App_User;
import com.FQW.CSDocumentFlow.models.Record_card_first;
import com.FQW.CSDocumentFlow.models.Record_card_second;
import com.FQW.CSDocumentFlow.models.Schedule;
import com.FQW.CSDocumentFlow.repo.App_UserRepository;
import com.FQW.CSDocumentFlow.repo.Record_card_firstRepository;
import com.FQW.CSDocumentFlow.repo.Record_card_secondRepository;
import com.FQW.CSDocumentFlow.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /*//@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/record_card")
    public String teaching_record_table(Model model) {
        Iterable<Record_card_first> rec_card_first = rec_card_first_Repository.findAll();
        model.addAttribute("rec_card_first", rec_card_first);
        Iterable<Record_card_second> rec_card_second = rec_card_second_Repository.findAll();
        model.addAttribute("rec_card_second", rec_card_second);
        return "teaching-record_card";
    }*/


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
}