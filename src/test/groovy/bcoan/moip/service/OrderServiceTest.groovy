package bcoan.moip.service

import bcoan.moip.domain.Coupon
import bcoan.moip.domain.Customer
import bcoan.moip.domain.Item
import bcoan.moip.domain.Order
import bcoan.moip.domain.Product
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.is
import static org.junit.Assert.assertThat

/**
 * Created by brunocoan on 1/26/16.
 */
class OrderServiceTest extends AbstractServiceTest {

    @Autowired
    OrderService service

    @Test
    void createOrderWithDiscont() {


        def order = service.create(newOrder())

        assertThat(order.discount, is(equalTo(BigDecimal.valueOf(5))))
        assertThat(order.totalWithDiscount, is(equalTo(BigDecimal.valueOf(95))))

    }

    Order newOrder() {

        new Order(customer: new Customer(name: "bruno", email: "brunocoann@gmail.com"),
                itens: [new Item(quantity: 1,
                        product: new Product(id: "a6ede688-b4bd-4315-9f07-5f57555bda28", price: 100))],
                coupon: new Coupon(id: "97faca93-2424-44d5-81bd-cfc56791d0ae", key: "DESCONTO5", discount: 0.05))
    }
}

