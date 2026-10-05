package com.dhruv.pdms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.dhruv.pdms.service.DocumentService;
import com.dhruv.pdms.service.ManufacturerPartService;
import com.dhruv.pdms.service.ManufacturerService;
import com.dhruv.pdms.service.PartService;
import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController 
{
    @Autowired
    private PartService partService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ManufacturerPartService manufacturerPartService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model)
    {
        if (session.getAttribute("username") == null) 
        {
            return "redirect:/login";
        }
        model.addAttribute("totalParts", partService.viewParts().size());
        model.addAttribute("totalDocuments", documentService.viewDocuments().size());
        model.addAttribute("totalManufacturers", manufacturerService.viewManufacturers().size());
        model.addAttribute("totalManufacturerParts", manufacturerPartService.viewManufacturerParts().size());
        return "dashboard";
    }
}
