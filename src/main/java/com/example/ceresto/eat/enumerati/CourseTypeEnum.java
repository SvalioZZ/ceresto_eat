package com.example.ceresto.eat.enumerati;

import jakarta.persistence.Id;

public enum CourseTypeEnum {
    
    BEVERAGE(1L),
    APPETIZER(2L),
    FIRST(3L),
    SECOND(4L),
    DESSERT(5L);
    
    
    private final Long id_courseType;
    
    CourseTypeEnum(Long id_courseType) {
        this.id_courseType = id_courseType;
    }
    
    public Long getId_courseType() {
        return id_courseType;
    }
}
