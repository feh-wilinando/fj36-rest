package br.com.caelum.fj36.rest.products;

import br.com.caelum.fj36.rest.models.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {



    private static final Map<Long, Product> database = new HashMap<>();


    @CacheEvict(cacheNames = "products", allEntries = true)
    public void save(Product product) {
        database.put(product.getId(), product);
    }

    @Cacheable(cacheNames = "products")
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public void delete(Product product) {
        database.remove(product.getId());
    }

    public List<Product> findAll() {
        return new ArrayList<>(database.values());
    }
}
