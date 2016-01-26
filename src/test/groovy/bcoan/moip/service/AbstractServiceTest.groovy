package bcoan.moip.service

import bcoan.moip.MoipIntegrationApplication
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

/**
 * Created by brunocoan on 1/26/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoipIntegrationApplication.class)
@WebAppConfiguration
class AbstractServiceTest {
}
