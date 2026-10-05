package com.dhruv.pdms.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "manufacturers")
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer 
{
    @Id
    private String manufacturerId;
    private String name;
    private String country;
}
