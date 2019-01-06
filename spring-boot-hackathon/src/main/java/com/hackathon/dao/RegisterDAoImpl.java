/**
 *
 */
package com.hackathon.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hackathon.entity.Register;


/**
 * @author mbollampalli
 */
@Transactional
@Repository
public class RegisterDAoImpl implements IRegisterDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int createReg(final Register register) {
        final Session session = sessionFactory.openSession();
        int regStatus = 0;
        try {
            regStatus = (int) session.save(register);
        }
        finally {
            session.clear();
            session.close();
        }
        return regStatus;

    }

    @Override
    public Register emailCheck(final String email) {
        final Session session = sessionFactory.openSession();
        Register regObj = null;
        try {
            final Criteria criteria = session.createCriteria(Register.class).add(Restrictions.eq("email", email));
            if (criteria.list().size() != 0) {
                regObj = (Register) criteria.list().get(0);
            }
        }
        finally {
            session.clear();
            session.close();
        }
        return regObj;
    }

}
