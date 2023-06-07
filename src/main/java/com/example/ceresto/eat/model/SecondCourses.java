package com.example.ceresto.eat.model;


import com.example.ceresto.eat.enumerati.IngredientiEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SecondCourses{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private List<IngredientiEnum> ingredientiEnumList;

    @Column (nullable = false)
    private Boolean highProteinValueParameter;


}
