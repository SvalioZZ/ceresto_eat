package com.example.ceresto.eat.enumerati;

public enum AllergeniciEnum {
    LATTOSIO(1L, "Latte", "This courses countains milk and derivatives"),
    GLUTINE(2L, "Grano", "This courses countains gluten and derivatives"),
    ARACHIDI(3L, "Arachidi", "This courses countains arach and derivatives"),
    FRUTTA_A_GUSCIO(4L, "Frutta a guscio", "This courses countains Walnuts and derivatives nuts"),
    SOIA(5L, "Soia", "This courses countains Soia and derivatives"),
    UOVA(6L, "Uova", "This courses countains eggs and derivatives"),
    PESCE(7L, "Pesce", "This courses countains fish and derivatives"),
    CROSTACEI(8L, "Crostacei", "This courses countains shellfish and derivatives"),
    SENAPE(9L, "Senape", "This courses countains mustard and derivatives"),
    SESAMO(10L, "Sesamo", "This courses countains sesame and derivatives"),
    SOLFITI(11L, "Solfiti", "This courses countains sulfites and derivatives");
    private String name;
    private String description;
    private Long id;
    
    AllergeniciEnum(Long id, String name, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}