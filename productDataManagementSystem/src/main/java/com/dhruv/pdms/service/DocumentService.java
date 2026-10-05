package com.dhruv.pdms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhruv.pdms.model.Document;
import com.dhruv.pdms.repository.DocumentRepository;

@Service
public class DocumentService
{
    @Autowired
    private DocumentRepository documentRepository;

    public void createDocument(String name, String description, String version) 
    {
        String documentNumber = generateNextNumber();
        Document document = new Document(documentNumber, name, description, version);
        documentRepository.save(document);
    }

    private String generateNextNumber()
    {
        int highest = 199;
        for (Document document : documentRepository.findAll())
        {
            try 
            {
                int number = Integer.parseInt(document.getNumber());
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

    public List<Document> viewDocuments() 
    {
        return documentRepository.findAll();
    }

    public boolean deleteDocument(String number)
    {
        if (!documentRepository.existsById(number))
        {
            return false;
        }
        documentRepository.deleteById(number);
        return true;
    }
}
