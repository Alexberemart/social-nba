package alexberemart.socialNBA.model.dao.impl;

import Alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.TwitDAO;
import alexberemart.socialNBA.model.vo.Twit;
import org.hibernate.criterion.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitDAOImpl extends GenericHibernateSpringDAOImpl<Twit, String> implements TwitDAO {

    public TwitDAOImpl() {
        super(Twit.class);
    }

    @Override
    public Twit getLastTwitById(String playerName) {
        final DetachedCriteria criteria = DetachedCriteria
                .forClass(Twit.class)
                .add(Restrictions.eq("playerName", playerName))
                .addOrder(Order.desc("twitId"));

        final List<Twit> byCriteria = this.getHibernateTemplate().findByCriteria(criteria);

        if (byCriteria.size() == 0) {
            return null;
        }

        return byCriteria.get(0);
    }

    @Override
    public List<Map<String, Object>> getPlayerTwitsWithPositiveAndNegativeCount() {
        final DetachedCriteria criteria = DetachedCriteria
                .forClass(Twit.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("playerName"))
                        .add(Projections.count("playerName"))
                        .add(Projections.sum("positiveWords"))
                        .add(Projections.sum("negativeWords"))
                );

        List<Object[]> queryResult = this.getHibernateTemplate().findByCriteria(criteria);

        if (queryResult.size() == 0) {
            return null;
        }

        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] item: queryResult){
            Map<String, Object> itemMap = new HashMap<>();
            itemMap.put("playerName", item[0]);
            itemMap.put("resultsNumber", item[1]);
            itemMap.put("positiveWordsNumber", item[2]);
            itemMap.put("negativeWordsNumber", item[3]);
            result.add(itemMap);
        }

        return result;
    }

}
