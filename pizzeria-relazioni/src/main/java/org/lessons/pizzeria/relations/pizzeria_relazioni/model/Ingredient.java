package org.lessons.pizzeria.relations.pizzeria_relazioni.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "The name cannot be empty.")
    @Size(min = 3, message = "The name must be at least 3 characters long.")
    private String name;
    
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.EAGER)
    private List<Pizza> pizzas;

    // #region getter e setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    // #endregion getter e setter
}
