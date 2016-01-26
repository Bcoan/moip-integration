package bcoan.moip.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate;
import java.io.Serializable
import java.util.Date

/**
 * Created by bruno on 14/01/16.
 */

@MappedSuperclass
class DomainEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String id

    @JsonIgnore
    Date createdAt

    @JsonIgnore
    Date updatedAt

    @PrePersist
    protected void preCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = new Date();
    }
}
