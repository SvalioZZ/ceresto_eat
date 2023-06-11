package com.example.ceresto.eat.enumerati;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public enum IngredientiEnum {
    STRAWBERRIES(1L, "Fragole"),
    CHOCALATE(2L, "Cioccolato"),
    COCOA(3L, "Cacao"),
    COFFEE(4L, "Caffè"),
    BUTTER(5L, "Burro"),
    MILK(6L, "Latte"),
    EGGS(7L, "Uova"),
    SUGAR(8L, "Zucchero"),
    YEAST(9L, "Lievito"),
    MILK_CREAM(10L, "Panna"),
    CREAM_CHEESE(11L, "Formaggio spalmabile"),
    MASCARPONE_CHEESE(12L, "Mascarpone"),
    FLOUR(13L, "Farina"),
    APPLES(14L, "Mele"),
    DRY_BISCUITS(15L, "Biscotti secchi"),
    SAVOIARDI_BISCUITS(16L, "Savoiardi"),
    HAZELNUTS(17L, "Nocciole"),
    SALT(18L, "Sale"),
    RED_FOOD_COLORING(19L, "Colorante alimentare rosso"),
    VANILLA(20L, "Vaniglia");
    
    private Long id;
    private String name;
    
    
    IngredientiEnum(Long id, String name) {
        this.id = id;
        this.name = name;
        
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
}


