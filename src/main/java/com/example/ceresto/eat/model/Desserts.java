package com.example.ceresto.eat.model;

import com.example.ceresto.eat.enumerati.IngredientiEnum;
import com.example.ceresto.eat.enumerati.PortateEnum;
import com.example.ceresto.eat.enumerati.RecordStatus;
import com.example.ceresto.eat.enumerati.SapiditaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @Column
    private PortateEnum type;
    @Column
    private Boolean containFrozenIngredients;
    @Column
    private Boolean glutenFree;
    @Column
    private Boolean lactoseFree;
    @Column
    private SapiditaEnum sugarLevel;
    //progetto vecchio SapiditaEnum dolcezza, come lo scrivo con springboot?

    @Column
    private List<IngredientiEnum> ingredientiEnumList;
    @Column
    private RecordStatus status;

    public Desserts() {
    }

    public Desserts(Long id, String name, Double price, String description, PortateEnum type, Boolean containFrozenIngredients,
                    Boolean glutenFree, Boolean lactoseFree, SapiditaEnum sugarLevel, List<IngredientiEnum> ingredientiEnumList,
                    RecordStatus status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
        this.containFrozenIngredients = containFrozenIngredients;
        this.glutenFree = glutenFree;
        this.lactoseFree = lactoseFree;
        this.sugarLevel = sugarLevel;
        this.ingredientiEnumList = ingredientiEnumList;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getContainFrozenIngredients() {
        return containFrozenIngredients;
    }

    public void setContainFrozenIngredients(Boolean containFrozenIngredients) {
        this.containFrozenIngredients = containFrozenIngredients;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Boolean getLactoseFree() {
        return lactoseFree;
    }

    public void setLactoseFree(Boolean lactoseFree) {
        this.lactoseFree = lactoseFree;
    }

    public SapiditaEnum getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(SapiditaEnum sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public List<IngredientiEnum> getIngredientiEnumList() {
        return ingredientiEnumList;
    }

    public void setIngredientiEnumList(List<IngredientiEnum> ingredientiEnumList) {
        this.ingredientiEnumList = ingredientiEnumList;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }

}
