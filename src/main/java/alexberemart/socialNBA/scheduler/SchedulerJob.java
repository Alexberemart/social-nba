package alexberemart.socialNBA.scheduler;

import alexberemart.socialNBA.services.TwitServices;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import twitter4j.TwitterException;

import java.io.IOException;

//TODO: Es posible mover el fichero de configuración del quartz al paquete que le corresponte?, si lo pones ahi no rula.  http://www.mkyong.com/jsf2/jsf-2-quartz-2-example/

public class SchedulerJob implements Job {

	@Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("JSF 2 + Quartz 2 example");
        try {
            TwitServices.getInstance().getPlayerTwits();
            TwitServices.getInstance().processTwits();
        } catch (TwitterException | IOException e) {
            e.printStackTrace();
        }

    }

}