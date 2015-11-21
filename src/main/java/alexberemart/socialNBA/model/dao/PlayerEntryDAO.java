package alexberemart.socialNBA.model.dao;

import Alexberemart.core.model.dao.base.hibernate.GenericHibernateDAO;
import alexberemart.socialNBA.model.vo.PlayerEntry;

import java.util.List;

public interface PlayerEntryDAO extends GenericHibernateDAO<PlayerEntry, String> {

    List<PlayerEntry> findWithFiltersPaginated(String orderBy, Integer offset, Integer limit, Boolean asc, String search);

    Number countSearchResults();
}
