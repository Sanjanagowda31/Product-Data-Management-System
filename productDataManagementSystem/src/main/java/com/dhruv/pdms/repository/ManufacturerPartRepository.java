package com.dhruv.pdms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dhruv.pdms.model.ManufacturerPart;

public interface ManufacturerPartRepository extends JpaRepository<ManufacturerPart, String> 
{
	
}
