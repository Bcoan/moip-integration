package bcoan.moip.controller

import bcoan.moip.domain.Product
import bcoan.moip.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * Created by bruno on 22/01/16.
 */

@RestController
@RequestMapping("/products")
class ProductController {

    ProductService service

    @Autowired
    ProductController(ProductService service) {
        assert service, "service must not be null"
        this.service = service
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Iterable<Product> findAll() {
        service.findAll()
    }
}
