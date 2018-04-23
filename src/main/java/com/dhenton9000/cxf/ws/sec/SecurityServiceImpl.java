package com.dhenton9000.cxf.ws.sec;

import com.dhenton9000.birt.jpa.domain.security.Applications;
import com.dhenton9000.birt.jpa.domain.security.Groups;
import com.dhenton9000.birt.jpa.domain.security.Users;
import com.dhenton9000.birt.jpa.service.security.ApplicationsService;
import com.dhenton9000.birt.jpa.service.security.GroupsService;
import com.dhenton9000.birt.jpa.service.security.UsersService;
import com.dhenton9000.sec.contract.securityservice.SecurityServiceWSDL;
import com.dhenton9000.sec.schema.securityservice.ApplicationsListType;
import com.dhenton9000.sec.schema.securityservice.ApplicationsType;
import com.dhenton9000.sec.schema.securityservice.GroupsListType;
import com.dhenton9000.sec.schema.securityservice.GroupsType;
import com.dhenton9000.sec.schema.securityservice.UsersListType;
import com.dhenton9000.sec.schema.securityservice.UsersType;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityServiceImpl implements SecurityServiceWSDL {

    @Autowired
    UsersService usersService;

    @Autowired
    ApplicationsService applicationsService;

    @Autowired
    GroupsService groupsService;

    @Override
    public ApplicationsType findApplication(BigInteger id) {
        Applications app = applicationsService.findOne(id.intValue());
        ApplicationsType e = new ApplicationsType();
        e.setApplicationName(app.getApplicationName());
        e.setId(id);
        return e;
    }

    @Override
    public UsersType findUser(BigInteger id) {
        Users a = usersService.findOne(id.intValue());
        UsersType e = new UsersType();
        e.setLogin(a.getLogin());
        e.setUsername(a.getUsername());
        e.setId(id);

        return e;
    }

    @Override
    public GroupsType findGroup(BigInteger id) {
        Groups a  = groupsService.findOne(id.intValue());
        GroupsType e = new GroupsType();
        e.setGroupName(a.getGroupName());
        e.setId(BigInteger.valueOf(a.getId()));
        return e;
    }

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

    @Override
    public UsersListType getUsers() {

        UsersListType userList = new UsersListType();

        List<Users> userItems = usersService.findAll();
        userItems.forEach((Users a) -> {
            UsersType e = new UsersType();
            e.setLogin(a.getLogin());
            e.setUsername(a.getUsername());
            e.setId(BigInteger.valueOf(a.getUserid()));
            userList.getUsers().add(e);
        });
        return userList;
    }

    @Override
    public GroupsListType getGroups() {
        GroupsListType groupList = new GroupsListType();

        List<Groups> groupItems = groupsService.findAll();
        groupItems.forEach(a -> {
            GroupsType e = new GroupsType();
            e.setGroupName(a.getGroupName());
            e.setId(BigInteger.valueOf(a.getId()));

            groupList.getGroups().add(e);

        });
        return groupList;
    }

}


/*

soap ui payload to call the groups function because it is parameterless

<soapenv:Envelope xmlns:ns2="http://dhenton9000.com/sec/schema/SecurityService" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
	<ns2:GetGroups />
   </soapenv:Body>
</soapenv:Envelope>


 */
