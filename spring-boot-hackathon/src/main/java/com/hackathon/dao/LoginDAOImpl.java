/**
 *
 */
package com.hackathon.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hackathon.entity.Login;


/**
 * @author mbollampalli
 */
@Transactional
@Repository
public class LoginDAOImpl implements ILoginDAO {
    @SuppressWarnings("unused")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Login getLogin(final String email) {
        final Session session = sessionFactory.openSession();
        Login loginObj = null;
        try {
            final Criteria criteria = session.createCriteria(Login.class).add(Restrictions.eq("email", email));
            if (criteria.list().size() != 0) {
                loginObj = (Login) criteria.list().get(0);
            }
        }
        finally {
            session.clear();
            session.close();
        }
        return loginObj;
    }

}
