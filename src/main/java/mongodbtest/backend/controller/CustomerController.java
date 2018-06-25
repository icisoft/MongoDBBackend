package mongodbtest.backend.controller;

import java.util.List;
import mongodbtest.backend.model.Customer;
import mongodbtest.backend.model.CustomerRepository;
import mongodbtest.backend.model.Product;
import mongodbtest.backend.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @Autowired
    private CustomerRepository repository;
    
    @Autowired
    private ProductRepository prodRepository;
    
    @GetMapping("customer")
    public List<Customer> index() {
        return this.repository.findAll();
    }
    
    @GetMapping("customer/{id}")
    public Customer show(@PathVariable("id") String id) {
        return this.repository.findById(id).get();
    }
    
    @PostMapping("customer")
    public String create(@RequestBody Customer customer) {
        return this.repository.save(customer).id;
    }
    
    @GetMapping("customertest")
    public Customer customer() {
        Product product = this.prodRepository.save(new Product("test"));
        Customer customer = new Customer("test1", "test1");
        
        customer.products.add(product);
        
        this.repository.save(customer);
        
        return customer;
        
    }
    
}
