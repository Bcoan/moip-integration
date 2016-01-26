package bcoan.moip.service

import bcoan.moip.domain.Product
import bcoan.moip.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by bruno on 22/01/16.
 */

@Service
class ProductService {

    ProductRepository repository
    @Autowired
    ProductService(ProductRepository repository) {
        assert repository, "repository must not be null"
        this.repository = repository
    }

    Iterable<Product> findAll() {
        repository.findAll()
    }
}
