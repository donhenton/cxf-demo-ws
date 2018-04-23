package com.dhenton9000.cxf.ws.sec;

import com.dhenton9000.birt.jpa.domain.security.Applications;
import com.dhenton9000.birt.jpa.service.security.ApplicationsService;
import com.dhenton9000.birt.jpa.service.security.UsersService;
import com.dhenton9000.sec.contract.securityservice.SecurityServiceWSDL;
import com.dhenton9000.sec.schema.securityservice.ApplicationsListType;
import com.dhenton9000.sec.schema.securityservice.ApplicationsType;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityServiceImpl implements SecurityServiceWSDL {

    @Autowired
    UsersService usersService;

    @Autowired
    ApplicationsService applicationsService;

    @Override
    public ApplicationsListType getApplications() {

        ApplicationsListType appList = new ApplicationsListType();

        List<Applications> appItems = applicationsService.findAll();
        appItems.forEach(a -> {
            ApplicationsType e = new ApplicationsType();
            e.setApplicationName(a.getApplicationName());
            e.setId(BigInteger.valueOf(a.getId()));
            
            appList.getApplications().add(e);
        
        });
        return appList;
    }

}
