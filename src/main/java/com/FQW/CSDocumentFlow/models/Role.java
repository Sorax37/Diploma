package com.FQW.CSDocumentFlow.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    APP_USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
