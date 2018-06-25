package mongodbtest.backend.model;

import org.springframework.data.annotation.Id;

public class Product {
    
    @Id
    public String id;
    
    public String name;
    
    public Product() {
        
    }
    
    public Product(String name) {
        this.name = name;
    }
    
}
