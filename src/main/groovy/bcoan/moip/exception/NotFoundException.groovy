package bcoan.moip.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

import java.util.function.Supplier

/**
 * Created by bruno on 22/01/16.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException implements Supplier<NotFoundException>{

    NotFoundException(String message) {
        super(message)
    }

    @Override
    NotFoundException get() {
        return this
    }
}
