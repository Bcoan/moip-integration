package bcoan.moip.domain

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToOne

/**
 * Created by bruno on 22/01/16.
 */
@Entity
class Payment extends DomainEntity {

    public static final BigDecimal TAX = 0.025


    Integer installmentQuantity

    @OneToOne(cascade = CascadeType.ALL)
    CreditCard card

    @JsonIgnore
    @OneToOne(mappedBy = "payment")
    Order order

    Boolean hasAdditionalTax() {
        installmentQuantity > 1
    }
}
