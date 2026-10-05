package com.dhruv.pdms.service;
import org.springframework.stereotype.Service;

@Service
public class LoginService 
{
    public boolean login(String username, String password) 
    {
        return "admin".equals(username) && "admin123".equals(password);
    }
}
