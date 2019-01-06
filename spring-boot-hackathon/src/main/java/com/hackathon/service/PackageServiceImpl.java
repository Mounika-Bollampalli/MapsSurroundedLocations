/**
 *
 */
package com.hackathon.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackathon.bo.PackageDetailsBO;
import com.hackathon.dao.IPackageDAO;
import com.hackathon.entity.Login;


/**
 * @author mbollampalli
 */
@Service
public class PackageServiceImpl implements IPackageService {
    @Autowired
    IPackageDAO packageDAO;

    @Override
    public List<PackageDetailsBO> getAllPackage() {
        return packageDAO.getAllPackage();
    }

    @Override
    public List<PackageDetailsBO> getPackage(final Login login) {
        // TODO Auto-generated method stub
        return packageDAO.getPackage(login);
    }

}
