package com.dhruv.pdms.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "parts")
@AllArgsConstructor
@NoArgsConstructor
public class Part
{
    @Id
    private String number;
    private String name;
    private String description;
    private String partType;
}
