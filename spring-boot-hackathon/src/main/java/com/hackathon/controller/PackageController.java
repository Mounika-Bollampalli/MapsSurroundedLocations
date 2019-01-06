/**
 *
 */
package com.hackathon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackathon.bo.PackageDetailsBO;
import com.hackathon.entity.Login;
import com.hackathon.service.IPackageService;


/**
 * @author mbollampalli
 */
@RestController
@RequestMapping("hackathon")
@CrossOrigin(origins = { "*" })
public class PackageController {
    @Autowired
    IPackageService packageService;

    @PostMapping("getallpackage")
    public List<PackageDetailsBO> getPackage(@RequestBody final Login login) {
        final List<PackageDetailsBO> packageDetailsList = packageService.getPackage(login);

        if (packageDetailsList == null) {
            return null;
        }

        return packageDetailsList;
    }

    @GetMapping("getallpackage")
    public List<PackageDetailsBO> getAllPackage() {
        final List<PackageDetailsBO> packageDetailsList = packageService.getAllPackage();

        if (packageDetailsList == null) {
            return null;
        }

        return packageDetailsList;
    }
}
