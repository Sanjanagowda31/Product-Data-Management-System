package com.dhruv.pdms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dhruv.pdms.model.Document;

public interface DocumentRepository extends JpaRepository<Document, String>
{
	
}
