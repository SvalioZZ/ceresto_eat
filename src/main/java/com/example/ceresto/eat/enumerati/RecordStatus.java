package com.example.ceresto.eat.enumerati;

public enum RecordStatus {
    DELETED("D"), ACTIVE("A");

    private String code;

    RecordStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
