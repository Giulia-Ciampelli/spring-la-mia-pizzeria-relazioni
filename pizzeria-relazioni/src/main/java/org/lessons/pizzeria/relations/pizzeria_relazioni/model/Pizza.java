package org.lessons.pizzeria.relations.pizzeria_relazioni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Una pizza avrà le seguenti informazioni:
// un id
// un nome
// una descrizione
// una foto (url)
// un prezzo

@Entity
@Table(name = "pizzas")
public class Pizza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "this field must contain at least one non-whitespace character")
    @Size(min = 3, max = 255, message = "the name must be between 3 and 255 characters")
    private String name;

    @NotBlank(message = "this field must contain at least one non-whitespace character")
    @Size(min = 10, max = 255, message = "the description must be between 10 and 255 characters")
    private String description;

    @NotBlank(message = "this field must contain at least one non-whitespace character")
    @Lob
    private String url;

    @NotNull(message = "this field cannot be empty")
    @Min(value = 0, message = "price cannot be negative")
    private float price;

    //#region getter e setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //#endregion getter e setter

    @Override
    public String toString() {
        return String.format("%s, %s, %.2f", this.name, this.description, this.price);
    }
}
