package com.dhruv.pdms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dhruv.pdms.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, String>
{
	
}
