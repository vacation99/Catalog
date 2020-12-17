package com.daniil.ProductCatalog.Controllers;

import com.daniil.ProductCatalog.Modells.Product;
import com.daniil.ProductCatalog.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/catalog")
    public String main(Model model) {
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("model", products);
        return "catalog";
    }

    @GetMapping("/clearTable")
    public String clear() {
        productRepo.deleteAll();
        return "redirect:/catalog";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String nameFilter, Model model) {
        Product product = productRepo.findByName(nameFilter);
        model.addAttribute("filter", product);
        return "filter";
    }
}
