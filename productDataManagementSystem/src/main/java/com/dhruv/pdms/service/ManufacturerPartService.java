package com.dhruv.pdms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhruv.pdms.model.ManufacturerPart;
import com.dhruv.pdms.repository.ManufacturerPartRepository;

@Service
public class ManufacturerPartService 
{
    @Autowired
    private ManufacturerPartRepository manufacturerPartRepository;

    public void createManufacturerPart(String manufacturerName, String linkedPartNumber) 
    {
        String number = generateNextNumber();
        ManufacturerPart manufacturerPart = new ManufacturerPart(number, manufacturerName, linkedPartNumber);
        manufacturerPartRepository.save(manufacturerPart);
    }

    private String generateNextNumber() 
    {
        int highest = 399;
        for (ManufacturerPart manufacturerPart : manufacturerPartRepository.findAll()) 
        {
            try
            {
                int number = Integer.parseInt(manufacturerPart.getManufacturerPartNumber());
                if (number > highest) 
                {
                    highest = number;
                }
            } catch (NumberFormatException ignored) 
            {
              
            }
        }

        return String.valueOf(highest + 1);
    }

    public List<ManufacturerPart> viewManufacturerParts()
    {
        return manufacturerPartRepository.findAll();
    }

    public boolean deleteManufacturerPart(String number)
    {
        if (!manufacturerPartRepository.existsById(number)) 
        {
            return false;
        }
        manufacturerPartRepository.deleteById(number);
        return true;
    }
}
