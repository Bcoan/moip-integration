package bcoan.moip;

import bcoan.moip.domain.Order;
import bcoan.moip.integration.MoipApi;
import bcoan.moip.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoipIntegrationApplication.class)
@WebAppConfiguration
public class MoipIntegrationApplicationTests {
	@Autowired
	private MoipApi api;

	@Test
	public void contextLoads() {
	}

}
