package bcoan.moip.domain.dto

import bcoan.moip.domain.Customer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by bruno on 25/01/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class CustomerDTO {

    String ownId
    String fullname
    String email

    CustomerDTO() {
    }

    CustomerDTO(Customer customer) {
        this.ownId = customer.id
        this.fullname = customer.name
        this.email = customer.email
    }
}
