package com.example.ceresto.eat.enumerati;

public enum SapiditaEnum {
    AMARISSIMO(1L, "Amarissimo"),
    AMARO(2L, "Amaro"),
    DOLCE(3L, "Dolce"),
    DOLCISSIMO(4L, "Dolcissimo"),
    SALATO(5L, "Salato"),
    SALATISSIMO(6L, "Salatissimo"),
    SCIAPO(7L, "Senza Sale"),
    AGRODOLCE(8L, "Agrodolce");

    private Long id;
    private String descrizione;

    SapiditaEnum(Long id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String name) {
        this.descrizione = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
