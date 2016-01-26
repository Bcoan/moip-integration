package bcoan.moip.controller

import bcoan.moip.domain.Order
import bcoan.moip.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

/**
 * Created by bruno on 20/01/16.
 */

@RestController
@RequestMapping(value = "/orders")
class OrderController {

    OrderService service

    @Autowired
    OrderController(OrderService service) {
        this.service = service
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Order create(@RequestBody @Validated Order order) {
        service.create(order)
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    Order update(@PathVariable("id") String id, @RequestBody Order order) {
        order.id = id
        service.update(order)
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Iterable<Order> findAll() {
        service.findAll()
    }

    @RequestMapping(value = "/{id}/checkout" , method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Order checkout(@PathVariable("id") String id, @RequestBody Order order) {
        order.id = id
        service.checkout(order)
    }
}
