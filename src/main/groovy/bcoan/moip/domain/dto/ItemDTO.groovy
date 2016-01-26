package bcoan.moip.domain.dto

import bcoan.moip.domain.Item
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by bruno on 25/01/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

class ItemDTO {

    String product
    Integer quantity
    String detail
    BigDecimal price

    ItemDTO() {
    }

    ItemDTO(Item item) {
        this.product = item.product?.name
        this.detail= item.product?.detail
        this.quantity = item.quantity
        this.price = item.product?.price
    }

    Long getPrice() {
        return price * 100
    }
}