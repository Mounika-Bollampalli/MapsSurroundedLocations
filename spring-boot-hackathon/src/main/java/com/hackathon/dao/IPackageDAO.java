/**
 *
 */
package com.hackathon.dao;

import java.util.List;
import com.hackathon.bo.PackageDetailsBO;
import com.hackathon.entity.Login;


/**
 * @author mbollampalli
 */
public interface IPackageDAO {
    public List<PackageDetailsBO> getAllPackage();

    public List<PackageDetailsBO> getPackage(Login login);

}
