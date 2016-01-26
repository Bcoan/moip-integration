package bcoan.moip.repository

import bcoan.moip.domain.Product
import org.springframework.data.repository.CrudRepository

/**
 * Created by bruno on 22/01/16.
 */
interface ProductRepository extends CrudRepository<Product, String> {

}