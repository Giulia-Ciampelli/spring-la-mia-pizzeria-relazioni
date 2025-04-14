package org.lessons.pizzeria.relations.pizzeria_relazioni.controller;

import java.util.List;

import org.lessons.pizzeria.relations.pizzeria_relazioni.model.Pizza;
import org.lessons.pizzeria.relations.pizzeria_relazioni.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    // dependency injection
    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizzas = repository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Pizza pizza = repository.findById(id).get();
        model.addAttribute("pizza", pizza);
        return "pizzas/show";
    }

    //#region ricerche personalizzate
    @GetMapping("/search-by-name")
    public String searchByName(@RequestParam(name = "name") String name, Model model) {
        List<Pizza> pizzas = repository.findByNameContainingIgnoreCase(name);
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }
    
    //#endregion ricerche personalizzate

    // create
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizzas/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {

        // controllo errori
        if (bindingResult.hasErrors()) {
            return "pizzas/create";
        }

        // salvataggio con la repository
        repository.save(formPizza);
        return "redirect:/pizzas";
    }

    // update
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("pizza", repository.findById(id).get());
        return "pizzas/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {

        // controllo errori
        if (bindingResult.hasErrors()) {
            return "pizzas/edit";
        }

        // salvataggio con la repository
        repository.save(formPizza);
        return "redirect:/pizzas";
    }

    // delete
    @PostMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/pizzas";
    }
    
}
