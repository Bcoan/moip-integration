package bcoan.moip.service

import bcoan.moip.domain.Order
import bcoan.moip.domain.Payment
import bcoan.moip.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by bruno on 25/01/16.
 */

@Service
class PaymentService {

    PaymentRepository repository

    OrderService orderService

    @Autowired
    PaymentService(PaymentRepository repository, OrderService orderService) {
        this.repository = repository
        this.orderService = orderService
    }

    Payment create(String orderId, Payment payment) {

        Order order = orderService.findOne(orderId)
        payment.order = order
        order.payment = payment
        repository.save(payment)
    }

}
