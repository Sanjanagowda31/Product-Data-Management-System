package com.dhruv.pdms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService
{
    @Autowired
    private PartService partService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ManufacturerPartService manufacturerPartService;

    public boolean deletePart(String number)
    {
        return partService.deletePart(number);
    }

    public boolean deleteDocument(String number) 
    {
        return documentService.deleteDocument(number);
    }

    public boolean deleteManufacturer(String id) 
    {
        return manufacturerService.deleteManufacturer(id);
    }

    public boolean deleteManufacturerPart(String number) 
    {
        return manufacturerPartService.deleteManufacturerPart(number);
    }
}
