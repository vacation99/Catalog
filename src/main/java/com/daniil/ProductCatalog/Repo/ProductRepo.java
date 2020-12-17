package com.daniil.ProductCatalog.Repo;

import com.daniil.ProductCatalog.Modells.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
    Product findById(long id);
    Product findByName(String name);
}
