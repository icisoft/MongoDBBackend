package mongodbtest.backend.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    
    public Product findByName(String name);
    
}
