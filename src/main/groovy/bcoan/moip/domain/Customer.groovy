package bcoan.moip.domain

import javax.persistence.Entity
import javax.validation.constraints.NotNull;

/**
 * Created by bruno on 14/01/16.
 */
@Entity
class Customer extends DomainEntity {

    @NotNull
    String name
    @NotNull
    String email
}
