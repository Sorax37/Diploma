package com.FQW.CSDocumentFlow.controllers;

import com.FQW.CSDocumentFlow.models.App_User;
import com.FQW.CSDocumentFlow.models.Role;
import com.FQW.CSDocumentFlow.repo.App_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private App_UserRepository app_userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(App_User user, Map<String, Object> model, @RequestParam Role role) {
        App_User app_user = app_userRepository.findByUsername(user.getUsername());
        if (app_user != null) {
            model.put("message", "Пользователь уже существует");
            return "registration";
        }
        user.setRoles(Collections.singleton(role));
        app_userRepository.save(user);
        return "redirect:/login";
    }
}
