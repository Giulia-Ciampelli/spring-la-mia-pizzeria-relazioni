package org.lessons.pizzeria.relations.pizzeria_relazioni.controller;

import org.lessons.pizzeria.relations.pizzeria_relazioni.model.OnSale;
import org.lessons.pizzeria.relations.pizzeria_relazioni.repository.OnSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/sales")
public class OnSaleController {
    
    @Autowired
    private OnSaleRepository repository;

    // sezione create
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("sale") OnSale formSale, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/create-edit";
        }
        repository.save(formSale);
        return "redirect:/pizzas/" + formSale.getPizza().getId();
    }
    
}
