package org.lessons.pizzeria.relations.pizzeria_relazioni.repository;

import org.lessons.pizzeria.relations.pizzeria_relazioni.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
    
}
