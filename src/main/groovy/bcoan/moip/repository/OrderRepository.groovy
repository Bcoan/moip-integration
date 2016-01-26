package bcoan.moip.repository

import bcoan.moip.domain.Order
import org.springframework.data.repository.CrudRepository

/**
 * Created by bruno on 20/01/16.
 */
interface OrderRepository extends CrudRepository<Order, String> {

}