package com.speakr.service;

import com.speakr.dao.UserDAO;
import com.speakr.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsImpl implements UserDetailsService {

    final UserDAO UserDAO;

    public JwtUserDetailsImpl(com.speakr.dao.UserDAO userDAO) {
        this.UserDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, NullPointerException {
        User user = UserDAO.findUserByUserName(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
        System.out.println(UserDAO.findAll());
        if (user == null) {
            throw new UsernameNotFoundException(String
                    .format("Username: \"%s\" does not exist.", username));
        }
        return new org.springframework.security.core.userdetails
                .User(user.getUserName(), user.getPassword(), authorityList);
    }


    public UserDetails createUserDetails(String username, String password) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
        return new org.springframework.security.core.userdetails.User
                (username, password, authorityList);
    }

}
