package alexberemart.socialNBA.scheduler;

import alexberemart.socialNBA.services.PlayerEntryServices;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.io.IOException;

//TODO: Es posible mover el fichero de configuración del quartz al paquete que le corresponte?, si lo pones ahi no rula.  http://www.mkyong.com/jsf2/jsf-2-quartz-2-example/

public class BasketReferenceJob implements Job {

	@Override
    public void execute(JobExecutionContext context) {
		
		System.out.println("start processBasketReferenceInfo");
        try {
            PlayerEntryServices.getInstance().processBasketReferenceInfo();
            System.out.println("finish processBasketReferenceInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}