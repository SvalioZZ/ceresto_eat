package com.example.ceresto.eat.enumerati;

public enum StatusEnum {
    DELETED("D"), ACTIVE("A");

    private String code;

    StatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
