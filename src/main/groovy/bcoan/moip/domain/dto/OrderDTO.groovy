package bcoan.moip.domain.dto

import bcoan.moip.domain.Order
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import java.util.stream.Collectors

/**
 * Created by bruno on 25/01/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
class OrderDTO {
    String id
    String ownId
    String status
    List<ItemDTO> items
    CustomerDTO customer
    Amount amount

    OrderDTO() {
    }

    OrderDTO(Order order) {
        this.ownId = order.id
        this.items = order.itens.stream()
                            .map{new ItemDTO(it)}.collect(Collectors.toList())
        this.customer = new CustomerDTO(order.customer)

        this.amount = new Amount(subtotals: new Subtotals(discount: order.discount))
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Amount {
    Subtotals subtotals
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Subtotals {
    BigDecimal discount

    Long getDiscount() {
        return discount * 100
    }
}