package bcoan.moip.rest

import bcoan.moip.MoipIntegrationApplication
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import javax.transaction.Transactional

import static bcoan.moip.MoipIntegrationApplication.*

/**
 * Created by bruno on 25/01/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoipIntegrationApplication.class)
@WebAppConfiguration
@Transactional
abstract class AbstractTest {
    @Autowired
    private WebApplicationContext context;

    protected MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
}