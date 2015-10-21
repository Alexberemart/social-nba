package alexberemart.socialNBA.services;

import Alexberemart.core.util.ApplicationContextProvider;
import alexberemart.socialNBA.model.dao.TwitDAO;
import alexberemart.socialNBA.model.vo.Twit;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitServices {

    @Autowired
    TwitDAO twitDAO;

    public static TwitServices getInstance() {
        return (TwitServices) ApplicationContextProvider.getInstance().getBean("twitServices");
    }

    public void saveTwit(Twit twit) {
        try {
            twitDAO.makePersistent(twit);
        } catch (Exception e) {
            System.out.println("No se ha podido cargar la línea de texto : " + twit.getText());
            //e.printStackTrace();
        }
    }

}
