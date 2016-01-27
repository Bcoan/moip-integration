package bcoan.moip.service

import bcoan.moip.domain.Order
import bcoan.moip.exception.NotFoundException
import bcoan.moip.exception.UnprocessableEntityException
import bcoan.moip.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by bruno on 20/01/16.
 */

@Service
class OrderService {

    OrderRepository repository
    MoipService moipService


    @Autowired
    OrderService(OrderRepository repository, MoipService moipService) {
        assert repository, 'repository must not be null'
        assert moipService, 'moipService must not be null'

        this.repository = repository
        this.moipService = moipService
    }

    Order create(Order order) {
        repository.save(order)
    }

    Iterable<Order> findAll() {
        repository.findAll()
    }

    Order findOne(String id) {

        if(! repository.exists(id)) {
            throw  new NotFoundException("order not found")
        }

        repository.findOne(id)
    }

    Order update(Order order) {

        repository.save(order)
    }

    Order checkout(Order order) {

        order = repository.findOne(order.id)

        validate(order)

        order = moipService.create(order)

        repository.save(order)
    }


    void validate(Order order) {
        if(!order.payment) {
            throw new UnprocessableEntityException("order needs payment to checkout")
        }
    }
}
