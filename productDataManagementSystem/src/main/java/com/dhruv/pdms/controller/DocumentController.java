package com.dhruv.pdms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dhruv.pdms.service.DocumentService;

@Controller
public class DocumentController
{
    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public String documents(Model model) 
    {
        model.addAttribute("documents", documentService.viewDocuments());
        return "documents";
    }

    @PostMapping("/documents/add")
    public String addDocument(@RequestParam String name, @RequestParam String description,@RequestParam String version)
    {
        documentService.createDocument(name, description, version);
        return "redirect:/documents";
    }

    @GetMapping("/documents/delete")
    public String deleteDocument(@RequestParam String number) 
    {
        documentService.deleteDocument(number);
        return "redirect:/documents";
    }
}
