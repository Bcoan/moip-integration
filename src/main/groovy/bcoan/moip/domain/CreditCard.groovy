package bcoan.moip.domain

import javax.persistence.Entity

/**
 * Created by bruno on 22/01/16.
 */
@Entity
class CreditCard extends DomainEntity {

    String hash
    String fullName
    String birthDate
}
