package bcoan.moip.controller

import bcoan.moip.domain.Payment
import bcoan.moip.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * Created by bruno on 25/01/16.
 */
@RestController
@RequestMapping("/orders/{orderId}/payments")
class PaymentController {

    PaymentService service

    @Autowired
    PaymentController(PaymentService service) {
        assert service, "Payment service must not be null"
        this.service = service
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Payment create(@PathVariable String orderId, @RequestBody Payment payment) {
        service.create(orderId, payment)
    }
}
