package com.dhruv.pdms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dhruv.pdms.service.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController 
{
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginPage() 
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,Model model) 
    {
        if (loginService.login(username, password))
        {
            session.setAttribute("username", username);
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) 
    {
        session.invalidate();
        return "redirect:/login";
    }
}
