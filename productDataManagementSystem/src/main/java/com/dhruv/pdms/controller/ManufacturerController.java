package com.dhruv.pdms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dhruv.pdms.service.ManufacturerService;

@Controller
public class ManufacturerController 
{
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/manufacturers")
    public String manufacturers(Model model)
    {
        model.addAttribute("manufacturers", manufacturerService.viewManufacturers());
        return "manufacturers";
    }

    @PostMapping("/manufacturers/add")
    public String addManufacturer(@RequestParam String name,@RequestParam String country) 
    {
        manufacturerService.createManufacturer(name, country);
        return "redirect:/manufacturers";
    }

    @GetMapping("/manufacturers/delete")
    public String deleteManufacturer(@RequestParam String id) 
    {
        manufacturerService.deleteManufacturer(id);
        return "redirect:/manufacturers";
    }
}
