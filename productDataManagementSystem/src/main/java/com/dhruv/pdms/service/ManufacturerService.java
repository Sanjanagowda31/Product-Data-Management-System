package com.dhruv.pdms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhruv.pdms.model.Manufacturer;
import com.dhruv.pdms.repository.ManufacturerRepository;

@Service
public class ManufacturerService
{
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public void createManufacturer(String name, String country)
    {
        String id = generateNextId();
        Manufacturer manufacturer = new Manufacturer(id, name, country);
        manufacturerRepository.save(manufacturer);
    }

    private String generateNextId()
    {
        int highest = 299;
        for (Manufacturer manufacturer : manufacturerRepository.findAll())
        {
            try {
                int number = Integer.parseInt(manufacturer.getManufacturerId());
                if (number > highest) {
                    highest = number;
                }
            } catch (NumberFormatException ignored)
            {
                
            }
        }

        return String.valueOf(highest + 1);
    }

    public List<Manufacturer> viewManufacturers() 
    {
        return manufacturerRepository.findAll();
    }

    public boolean deleteManufacturer(String id) 
    {
        if (!manufacturerRepository.existsById(id))
        {
            return false;
        }
        manufacturerRepository.deleteById(id);
        return true;
    }
}
