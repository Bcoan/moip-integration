package bcoan.moip.rest

import org.junit.Test
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Created by bruno on 26/01/16.
 */
class CouponControllerTest extends AbstractTest {

    @Test
    public void testGetCouponByKey() throws Exception {
        this.mvc.perform(get("/coupons/{key}", "DESCONTO5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testCouponNotFound() throws Exception {
        this.mvc.perform(get("/coupons/{key}", "DESCONTO10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
