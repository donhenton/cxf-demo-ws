/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.service.security;

import com.dhenton9000.jpa.domain.security.Applications;
import com.dhenton9000.jpa.domain.security.Groups;
import com.dhenton9000.jpa.domain.security.Users;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface UsersService {
    
    List<Users> findAll();
    Users findOne(Integer id);
    Users findByLogin(String name);
    List<Applications> findAuthorizedApplications(Integer id);
    List<Groups> findGroupsForUser(Integer id);
    Users save(Users user);
    Users delete(Users user);
    
}
