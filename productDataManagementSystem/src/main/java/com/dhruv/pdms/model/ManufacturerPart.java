package com.dhruv.pdms.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "manufacturer_parts")
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerPart
{
    @Id
    private String manufacturerPartNumber;
    private String manufacturerName;
    private String linkedPartNumber;
}
