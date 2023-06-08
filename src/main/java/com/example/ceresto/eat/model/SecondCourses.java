package com.example.ceresto.eat.model;


import com.example.ceresto.eat.enumerati.IngredientiEnum;
import com.example.ceresto.eat.enumerati.RecordStatus;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table
public class SecondCourses extends Record{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private List<IngredientiEnum> ingredientiEnumList;

    @Column (nullable = false)
    private Boolean highProteinValueParameter;

    public SecondCourses(RecordStatus status, Long id, String name, Double price, String description, List<IngredientiEnum> ingredientiEnumList, Boolean highProteinValueParameter) {
        super(RecordStatus.ACTIVE);
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ingredientiEnumList = ingredientiEnumList;
        this.highProteinValueParameter = highProteinValueParameter;
    }

    public SecondCourses() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IngredientiEnum> getIngredientiEnumList() {
        return ingredientiEnumList;
    }

    public void setIngredientiEnumList(List<IngredientiEnum> ingredientiEnumList) {
        this.ingredientiEnumList = ingredientiEnumList;
    }

    public Boolean getHighProteinValueParameter() {
        return highProteinValueParameter;
    }

    public void setHighProteinValueParameter(Boolean highProteinValueParameter) {
        this.highProteinValueParameter = highProteinValueParameter;
    }
}
