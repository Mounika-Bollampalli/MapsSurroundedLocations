/**
 *
 */
package com.hackathon.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hackathon.bo.DriverBO;
import com.hackathon.bo.PackageDetailsBO;
import com.hackathon.entity.Driver;
import com.hackathon.entity.Login;
import com.hackathon.entity.PackageDetails;


/**
 * @author mbollampalli
 */
@Transactional
@Repository
public class PackageDAOImpl implements IPackageDAO {
    @SuppressWarnings("unused")
    @Autowired
    private SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<PackageDetailsBO> getAllPackage() {
        final Session session = sessionFactory.getCurrentSession();
        List<PackageDetailsBO> packageDetails = null;
        try {

            final Criteria criteria = session.createCriteria(PackageDetails.class);
            if (criteria.list() != null && criteria.list().size() != 0) {
                final List<PackageDetails> packageDetailsVo = criteria.list();
                packageDetails = maptoGetAllPackageDetailsBO(packageDetailsVo);
            }
        }
        finally {

        }
        return packageDetails;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PackageDetailsBO> getPackage(final Login login) {
        final Session session = sessionFactory.getCurrentSession();
        List<PackageDetailsBO> packageDetails = null;
        try {

            final Criteria criteria = session.createCriteria(PackageDetails.class);
            if (login.getRole().equalsIgnoreCase("DRIVER")) {
                final Criteria criterias = session.createCriteria(Driver.class);
                criterias.add(Restrictions.eq("email", login.getEmail()));
                final Driver driver = (Driver) criterias.list().get(0);
                criteria.add(Restrictions.eq("driver_details.driver_id", driver.getDriver_id()));
            }
            if (criteria.list() != null && criteria.list().size() != 0) {
                final List<PackageDetails> packageDetailsVo = criteria.list();
                packageDetails = maptoGetAllPackageDetailsBO(packageDetailsVo);
            }
        }
        finally {

        }
        return packageDetails;
    }

    @SuppressWarnings("null")
    public List<PackageDetailsBO> maptoGetAllPackageDetailsBO(final List<PackageDetails> packageDetailsVo) {
        final List<PackageDetailsBO> packageDetails = new ArrayList<>();

        packageDetailsVo.forEach(packageBO -> {
            final PackageDetailsBO packageDetailsBO = new PackageDetailsBO();
            packageDetailsBO.setForm_address(packageBO.getForm_address());
            packageDetailsBO.setTo_address(packageBO.getTo_address());
            packageDetailsBO.setPackage_id(packageBO.getPackage_id());
            final DriverBO driverBO = new DriverBO();
            driverBO.setName(packageBO.getDriver_details().getName());
            driverBO.setDriver_id(packageBO.getDriver_details().getDriver_id());
            driverBO.setPh_no(packageBO.getDriver_details().getPh_no());
            driverBO.setAddress(packageBO.getDriver_details().getAddress());
            driverBO.setEmail(packageBO.getDriver_details().getEmail());
            packageDetailsBO.setDriver_details(driverBO);
            packageDetailsBO.setStatus("Success");
            packageDetails.add(packageDetailsBO);
        });

        return packageDetails;

    }
}
