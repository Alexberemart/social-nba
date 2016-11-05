package alexberemart.socialNBA;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:alexberemart/socialNBA/context.xml"
})
public abstract class SocialNbaMedalsTest extends AbstractJUnit4SpringContextTests {
}
