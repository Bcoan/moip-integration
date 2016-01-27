package bcoan.moip.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

import java.util.function.Supplier

/**
 * Created by bruno on 26/01/16.
 */

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

class UnprocessableEntityException extends RuntimeException implements Supplier<NotFoundException> {

    UnprocessableEntityException(String message) {
        super(message)
    }

    @Override
    NotFoundException get() {
        return this
    }
}
