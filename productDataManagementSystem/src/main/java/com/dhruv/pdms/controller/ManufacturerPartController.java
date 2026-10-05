package com.dhruv.pdms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dhruv.pdms.service.ManufacturerPartService;

@Controller
public class ManufacturerPartController 
{
    @Autowired
    private ManufacturerPartService manufacturerPartService;

    @GetMapping("/manufacturer-parts")
    public String manufacturerParts(Model model)
    {
        model.addAttribute("manufacturerParts", manufacturerPartService.viewManufacturerParts());
        return "manufacturer-parts";
    }

    @PostMapping("/manufacturer-parts/add")
    public String addManufacturerPart(@RequestParam String manufacturerName, @RequestParam String linkedPartNumber)
    {
        manufacturerPartService.createManufacturerPart(manufacturerName, linkedPartNumber);
        return "redirect:/manufacturer-parts";
    }

    @GetMapping("/manufacturer-parts/delete")
    public String deleteManufacturerPart(@RequestParam String number) 
    {
        manufacturerPartService.deleteManufacturerPart(number);
        return "redirect:/manufacturer-parts";
    }
}
