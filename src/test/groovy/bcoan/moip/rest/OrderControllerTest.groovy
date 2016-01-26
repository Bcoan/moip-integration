package bcoan.moip.rest

import bcoan.moip.domain.Customer
import bcoan.moip.domain.Item
import bcoan.moip.domain.Order
import bcoan.moip.domain.Product
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.springframework.boot.json.JacksonJsonParser
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bruno on 25/01/16.
 */
class OrderControllerTest extends AbstractTest {

    @Test
    public void testCreateNewOrder() throws Exception {
        this.mvc.perform(post("/orders")
                .content(newOrder())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateInvalidOrder() throws Exception {
        this.mvc.perform(post("/orders")
                .content(invalidOrder())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testListOrders() throws Exception {
        this.mvc.perform(get("/orders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    String newOrder() {

       def order = new Order(customer: new Customer(name: "bruno", email: "brunocoann@gmail.com"),
                    itens: [new Item(quantity: 1,
                            product: new Product(id: "a6ede688-b4bd-4315-9f07-5f57555bda28"))])

        new ObjectMapper().writeValueAsString(order)

    }
    String invalidOrder() {

       def order = new Order()
        new ObjectMapper().writeValueAsString(order)

    }
}
