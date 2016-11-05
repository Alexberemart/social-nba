package alexberemart.socialNBA.model.dao.impl;

import com.alexberemart.core.model.dao.base.hibernate.spring.impl.GenericHibernateSpringDAOImpl;
import alexberemart.socialNBA.model.dao.MatchDAO;
import alexberemart.socialNBA.model.vo.Match;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;

import java.sql.SQLException;
import java.util.List;

public class MatchDAOImpl extends GenericHibernateSpringDAOImpl<Match, String> implements MatchDAO {

    public MatchDAOImpl() {
        super(Match.class);
    }

    @Override
    public Boolean ExistByKey(String key){
        final DetachedCriteria criteria = DetachedCriteria
                .forClass(Match.class)
                .add(Restrictions.eq("idImported", key));

        final List<Match> byCriteria = this.getHibernateTemplate().findByCriteria(criteria);

        if (byCriteria.size() == 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
