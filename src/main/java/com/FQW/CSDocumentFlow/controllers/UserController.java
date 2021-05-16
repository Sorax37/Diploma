package com.FQW.CSDocumentFlow.controllers;


import com.FQW.CSDocumentFlow.repo.App_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private App_UserRepository app_userRepository;



}
