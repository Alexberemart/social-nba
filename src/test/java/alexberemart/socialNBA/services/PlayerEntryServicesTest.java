package alexberemart.socialNBA.services;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/alexberemart/socialNBA/context.xml"
})
@Transactional
public class PlayerEntryServicesTest extends AbstractTransactionalJUnit4SpringContextTests {

    //TODO: Que hacer en este caso ??, no vamos a hacer un test para bajar todos los partidos ....
    @Test
    @Ignore
    public void getBasketReferenceInfo() throws Exception {
        PlayerEntryServices.getInstance().processBasketReferenceInfo();
    }
}
