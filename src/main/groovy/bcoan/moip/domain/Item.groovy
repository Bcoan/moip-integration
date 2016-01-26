package bcoan.moip.domain

import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

/**
 * Created by bruno on 20/01/16.
 */
@Entity
class Item extends DomainEntity {

    @NotNull
    Integer quantity

    @OneToOne
    @NotNull
    Product product

    BigDecimal getTotal() {
        product?.price * quantity

    }
}
