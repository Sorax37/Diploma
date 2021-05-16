package com.FQW.CSDocumentFlow.service;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        if (user == null) {
            throw new UsernameNotFoundException("User with username '" + username + "' does not exist.");
        }
        return user;
    }
}