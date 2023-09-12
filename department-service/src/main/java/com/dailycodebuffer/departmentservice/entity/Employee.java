package com.dailycodebuffer.departmentservice.entity;

//This will be final class. All properties through constructor. No setters. Only getters
//public record Employee(

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long departmentId;
    private String name;
    private int age;
    private String position;

    @ManyToOne
    private Department department;

}
