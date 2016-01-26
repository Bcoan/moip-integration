package bcoan.moip.domain

import javax.persistence.Entity

/**
 * Created by bruno on 20/01/16.
 */

@Entity
class Coupon extends DomainEntity {
    String key
    Double discount
}
