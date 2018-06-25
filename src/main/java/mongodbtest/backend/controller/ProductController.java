package mongodbtest.backend.controller;

import java.util.List;
import mongodbtest.backend.model.Product;
import mongodbtest.backend.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository repository;
    
    @GetMapping("product")
    public List<Product> index() {
        return this.repository.findAll();
    }
    
    @GetMapping("product/{id}")
    public Product show(@PathVariable("id") String id) {
        return this.repository.findById(id).get();
    }
    
    @PostMapping("product")
    public String create(@RequestBody Product product) {
        return this.repository.save(product).id;
    }
    
}
