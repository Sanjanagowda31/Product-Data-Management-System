package com.dhruv.pdms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhruv.pdms.model.Part;
import com.dhruv.pdms.repository.PartRepository;

@Service
public class PartService
{
    @Autowired
    private PartRepository partRepository;

    public void createPart(String name, String description, String partType)
    {
        String partNumber = generateNextPartNumber();
        Part part = new Part( partNumber,name, description,partType);
        partRepository.save(part);
    }

    private String generateNextPartNumber() 
    {
        int highest = 99;
        for (Part part : partRepository.findAll())
        {
            try 
            {
                int number = Integer.parseInt(part.getNumber());
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

    public List<Part> viewParts()
    {
        return partRepository.findAll();
    }

    public boolean deletePart(String number) 
    {
        if (!partRepository.existsById(number)) 
        {
            return false;
        }

        partRepository.deleteById(number);
        return true;
    }
}
