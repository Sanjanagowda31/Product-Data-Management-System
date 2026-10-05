package com.dhruv.pdms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dhruv.pdms.service.PartService;

@Controller
public class PartController 
{
    @Autowired
    private PartService partService;

    @GetMapping("/parts")
    public String parts(Model model)
    {
        model.addAttribute("parts", partService.viewParts());
        return "parts";
    }

    @PostMapping("/parts/add")
    public String addPart(@RequestParam String name,@RequestParam String description,@RequestParam String partType)
    {
        partService.createPart(name, description, partType);
        return "redirect:/parts";
    }

    @GetMapping("/parts/delete")
    public String deletePart(@RequestParam String number)
    {
        partService.deletePart(number);
        return "redirect:/parts";
    }
}
