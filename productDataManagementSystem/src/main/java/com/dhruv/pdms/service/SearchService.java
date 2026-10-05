package com.dhruv.pdms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService 
{
    @Autowired
    private PartService partService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ManufacturerPartService manufacturerPartService;

    public PartService getPartService() 
    {
        return partService;
    }

    public DocumentService getDocumentService() 
    {
        return documentService;
    }

    public ManufacturerService getManufacturerService() 
    {
        return manufacturerService;
    }

    public ManufacturerPartService getManufacturerPartService()
    {
        return manufacturerPartService;
    }
}
