package bcoan.moip.domain

import javax.persistence.Entity

/**
 * Created by bruno on 20/01/16.
 */

@Entity
class Product extends DomainEntity {

    String name
    String detail
    BigDecimal price = BigDecimal.ZERO
}
