package bcoan.moip.repository

import bcoan.moip.domain.Payment
import org.springframework.data.repository.CrudRepository

/**
 * Created by bruno on 25/01/16.
 */
interface PaymentRepository extends CrudRepository<Payment, String > {

}