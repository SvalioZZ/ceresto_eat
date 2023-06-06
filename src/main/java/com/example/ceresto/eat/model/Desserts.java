package com.example.ceresto.eat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Desserts extends Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean containFrozenIngredients;

    @Column(nullable = false)
    private Boolean glutenFree;

    @Column(nullable = false)
    private Boolean lactoseFree;

    //progetto vecchio SapiditaEnum dolcezza, come lo scrivo con springboot?

}
