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
import java.util.Optional;

@Controller
//@PreAuthorize("hasAuthority('ADMIN')")
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

    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/update/schedule")
    public String teaching_schedule_update(Model model) { return "teaching-schedule_update";}

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teaching/update/schedule")
    public String schedule_new_update(@RequestParam String day_of_the_week, @RequestParam String period, @RequestParam String student_group, @RequestParam String discipline, @RequestParam String audience, @RequestParam String teacher, Model model) {
        Schedule schedule = new Schedule(day_of_the_week, period, student_group, discipline, audience, teacher);
        scheduleRepository.save(schedule);
        return "redirect:/teaching/schedule";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/record_card")
    public String teaching_record_table(Model model) {
        Iterable<Record_card_first> rec_card_first = rec_card_first_Repository.findAll();
        model.addAttribute("rec_card_first", rec_card_first);
        Iterable<Record_card_second> rec_card_second = rec_card_second_Repository.findAll();
        model.addAttribute("rec_card_second", rec_card_second);
        return "teaching-record_card";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/teaching/update/record_card")
    public String teaching_record_card_update(Model model) {
        return "teaching-card_update";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/teaching/update/card_first")
    public String card_new_update_first(@RequestParam String FIO, @RequestParam String discipline, @RequestParam String lesson_type, @RequestParam String student_group, @RequestParam String date, @RequestParam int number_of_hours, Model model) {
        Record_card_first record_card_first = new Record_card_first(FIO, discipline, lesson_type, student_group, date, number_of_hours);
        rec_card_first_Repository.save(record_card_first);
        return "redirect:/teaching/record_card";
    }

    /*@GetMapping("/teaching/record_card/{id}")
    public String teaching_record_table_id(@PathVariable(value = "id") long id, App_User user, Model model) {
        App_User app_user = app_userRepository.findByUsername(user.getUsername());
        id = app_user.getId();
        String user_FIO = app_user.getFIO();
        Optional<Record_card_first> card = rec_card_first_Repository.findById(id);
        ArrayList<Record_card_first> curr_card = new ArrayList<>();

        return "teaching-record_card";
    }*/


    @GetMapping("/teaching/record_cardsss")
    public String teaching_record_table_id(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String usname = userDetails.getUsername();
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("usname", usname);
        return "teaching-record_card";
    }

}