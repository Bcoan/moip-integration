package bcoan.moip.service

import bcoan.moip.domain.Order
import bcoan.moip.domain.OrderStatus
import bcoan.moip.domain.dto.OrderDTO
import bcoan.moip.integration.MoipApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import retrofit2.Call

/**
 * Created by bruno on 25/01/16.
 */

@Service
class MoipService {

    Logger logger = LoggerFactory.getLogger(MoipService)

    MoipApi api

    @Autowired
    MoipService(MoipApi api) {
        this.api = api
    }

    Order create(Order order) {

        def moipOrder = new OrderDTO(order)

        def response = api.createOrder(moipOrder).execute()

        if(response.success) {
            order.externalId =  response.body().id
        } else {
            order.status = OrderStatus.FAILED
            logger.error(response.errorBody().toString())
        }

    order

    }
}
