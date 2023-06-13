package com.example.ceresto.eat.enumerati;

public enum IngredientTypeEnum {
    MEAT(1L),
    FISH(2L),
    VEGETABLE(3L),
    FRUIT(4L),
    CEREAL(5L),
    LEGUME(6L),
    DRESSING(7L),
    SOUCE(8L),
    CHEESE(9L),
    DERIVATE_MILK(10L),
    DERIVATE_MEAT(11L),
    DERIVATE_CEREAL(12L),
    SPICE(13L),
    DRIED_FRUIT(14L),
    DRY_BISCUITS(15L);
    
    private Long id;
    
    
    IngredientTypeEnum(Long id) {
        this.id = id;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}


