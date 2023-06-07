package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.IngredientiEnum;
import com.example.ceresto.eat.enumerati.SapiditaEnum;
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
public class Desserts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean containFrozenIngredients;

    @Column(nullable = false)
    private Boolean glutenFree;

    @Column(nullable = false)
    private Boolean lactoseFree;

    @Column(nullable = false)
    private SapiditaEnum dolcezza;

    @Column(nullable = true)
    private List<IngredientiEnum> ingredientiEnumList;

    //progetto vecchio SapiditaEnum dolcezza, come lo scrivo con springboot?

}
