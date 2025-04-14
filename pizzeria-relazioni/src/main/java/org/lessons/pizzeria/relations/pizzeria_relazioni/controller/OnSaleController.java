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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    // sezione edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("sale", repository.findById(id).get());
        model.addAttribute("edit", true);
        return "sales/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("sale") OnSale formSale, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/create-edit";
        }
        repository.save(formSale);
        return "redirect:/pizzas/" + formSale.getPizza().getId();
    }
}
