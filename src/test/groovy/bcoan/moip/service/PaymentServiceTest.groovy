package bcoan.moip.service

import bcoan.moip.domain.CreditCard
import bcoan.moip.domain.Customer
import bcoan.moip.domain.Item
import bcoan.moip.domain.Order
import bcoan.moip.domain.Payment
import bcoan.moip.domain.Product
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static org.hamcrest.Matchers.closeTo
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.is
import static org.hamcrest.Matchers.notNullValue
import static org.junit.Assert.assertThat

/**
 * Created by bruno on 26/01/16.
 */
class PaymentServiceTest extends AbstractServiceTest {

    @Autowired
    PaymentService service

    @Autowired
    OrderService orderService

    Order order

    @Before
    void setup() {
        order =  new Order(customer: new Customer(name: "bruno", email: "brunocoann@gmail.com"),
                itens: [new Item(quantity: 1,
                        product: new Product(id: "a6ede688-b4bd-4315-9f07-5f57555bda28", price: 100))])

        order = orderService.create(order)

    }

    @Test
    void createSimplePayment() {

        def payment = service.create(order.id, newPayment())
        assertThat(payment.id, is(notNullValue()))

    }
    @Test
    void createPaymentAndVerifyValue() {

        def payment = service.create(order.id, newPayment())

        assertThat(order.totalWithDiscount, is(equalTo(BigDecimal.valueOf(100))))

    }
    @Test
    void createPaymentWithInstallmentsAndVerifyValue() {

        def payment = service.create(order.id, paymentWithInstalments())

        assertThat(order.totalWithDiscount, is(closeTo(BigDecimal.valueOf(102.5), BigDecimal.valueOf(0.01))))

    }

    Payment newPayment() {
        new Payment(installmentQuantity: 1,
                    card: new CreditCard(hash: "5644654646465465", fullName: "bruno coan",
                            birthDate: "30-01-1990"))
    }
    Payment paymentWithInstalments() {
        new Payment(installmentQuantity: 3,
                    card: new CreditCard(hash: "5644654646465465", fullName: "bruno coan",
                            birthDate: "30-01-1990"))
    }
}
