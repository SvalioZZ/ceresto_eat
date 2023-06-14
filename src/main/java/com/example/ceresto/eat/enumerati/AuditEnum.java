package com.example.ceresto.eat.enumerati;

public enum AuditEnum {
    DELETED("D"), ACTIVE("A");

    private String code;

    AuditEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
