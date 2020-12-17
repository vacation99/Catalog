package com.daniil.ProductCatalog.Controllers;

import com.daniil.ProductCatalog.Modells.Product;
import com.daniil.ProductCatalog.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/addProduct")
    public String add() {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String nameProduct, @RequestParam String descriptionProduct) {
        Product product = new Product(nameProduct, descriptionProduct);
        productRepo.save(product);
        return "redirect:/addProduct";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id) {
        Product product = productRepo.findById(id);
        productRepo.delete(product);
        return "redirect:/catalog";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable long id, Model model) {
        Product product = productRepo.findById(id);
        model.addAttribute("model", product);
        return "getProduct";
    }

    @PostMapping("/product/{id}")
    public String edit(@PathVariable long id, @RequestParam String nam, @RequestParam String des) {
        Product product = productRepo.findById(id);
        product.setName(nam);
        product.setDescription(des);
        productRepo.save(product);
        return "redirect:/catalog";
    }
}
