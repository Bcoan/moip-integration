package bcoan.moip.repository

import bcoan.moip.domain.Coupon
import org.springframework.data.repository.CrudRepository

/**
 * Created by bruno on 20/01/16.
 */
interface CouponRepository extends CrudRepository<Coupon, String> {

    Optional<Coupon> findByKey(String key)

}