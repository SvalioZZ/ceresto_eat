package com.example.ceresto.eat.enumerati;

public enum TypeEnum {
    MEAT("A base di Carne"),
    VEGAN("Vegano"),
    FISH ("A base di Pesce"),
    CHEF ("Menu dello Chef"),
    HOUSE ("Menu della Casa"),
    DAY("Menu del Giorno"),
    TASTING ("Menu Degustazione"),
    KID ("Menu Bambino");

    private final String description;
    
    TypeEnum(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
