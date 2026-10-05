package com.dhruv.pdms.repository;
import com.dhruv.pdms.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PartRepository extends JpaRepository<Part, String>
{
    List<Part> findByNumberStartingWith(String prefix);
}
