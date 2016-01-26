package bcoan.moip.domain

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull


/**
 * Created by bruno on 14/01/16.
 */

@Entity
@Table(name="tbl_order")
class Order extends DomainEntity {

    OrderStatus status = OrderStatus.CREATED

    String ExternalId

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    Customer customer

    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    List<Item> itens = []

    @OneToOne
    Coupon coupon

    @OneToOne
    Payment payment

    BigDecimal getTotal() {
        BigDecimal total = itens*.total.sum()
    }

    BigDecimal getDiscount() {
        if(coupon) {
            return coupon.discount * total
        }

        BigDecimal.ZERO
    }
    BigDecimal getTotalWithDiscount() {
        def value = total
        value = applyCoupon(value)
        value = applyAdditionalTax(value)
        value
    }


    BigDecimal applyCoupon(BigDecimal value) {
        if(coupon) {
            value = value - discount
        }

        value
    }

    BigDecimal applyAdditionalTax(BigDecimal value) {
        if(payment && payment.hasAdditionalTax()) {
            value = value + payment.TAX * value
        }
        value
    }


}
