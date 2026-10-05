package com.dhruv.pdms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.dhruv.pdms.service.SearchService;

@Controller
public class SearchController
{
    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String search(Model model)
    {
        model.addAttribute("parts", searchService.getPartService().viewParts());
        model.addAttribute("documents", searchService.getDocumentService().viewDocuments());
        model.addAttribute("manufacturers", searchService.getManufacturerService().viewManufacturers());
        model.addAttribute("manufacturerParts", searchService.getManufacturerPartService().viewManufacturerParts());
        return "search";
    }
}
