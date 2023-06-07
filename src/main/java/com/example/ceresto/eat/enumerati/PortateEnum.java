package com.example.ceresto.eat.enumerati;

public enum PortateEnum {
    
    BEVERAGES(1, "------- BEVANDE -------"),
    APPETIZERS(2, "------- ANTIPASTI -------"),
    FIRST(3, "------- PRIMI PIATTI -------"),
    SECOND(4, "------- SECONDI PIATTI -------"),
    DESSERT(5, "------- DESSERTS -------");
    
    private final String nome;
    private final Integer key;
    
    PortateEnum(Integer key, String nome) {
        this.nome =  nome ;
        this.key = key;
    }

    public String getNome() {
        return nome;
    }

    public Integer getKey() {
        return key;
    }


}
